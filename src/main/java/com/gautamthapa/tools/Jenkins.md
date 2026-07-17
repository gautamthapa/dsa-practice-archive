# Jenkins 🚀

Continuous Integration and Continuous Deployment (CI/CD) tool for automation.

---

## What is Jenkins?

Jenkins is an open-source automation server used for:
- **Building** code automatically when pushed to repository
- **Testing** code automatically
- **Deploying** code to production automatically
- **Monitoring** build health

---

## Pipeline Concept

A Pipeline is a series of automated steps:

```
Developer pushes code
        ↓
GitHub webhook triggers Jenkins
        ↓
[Stage 1] CHECKOUT: Pull code from Git
        ↓
[Stage 2] BUILD: Compile Java code (Maven)
        ↓
[Stage 3] TEST: Run unit tests
        ↓
[Stage 4] ANALYZE: Check code quality (SonarQube)
        ↓
[Stage 5] PACKAGE: Create JAR/WAR
        ↓
[Stage 6] DEPLOY: Push to staging server
        ↓
[Stage 7] SMOKE TEST: Verify app is running
        ↓
Build Complete! ✅
```

---

## Jenkins Pipeline Structure

### Declarative Pipeline (Easier)
```groovy
pipeline {
    // Define agent (where to run)
    agent any
    
    // Build configuration
    stages {
        // Stage 1: Checkout code
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        // Stage 2: Build
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        // Stage 3: Test
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        // Stage 4: Deploy
        stage('Deploy') {
            steps {
                sh 'docker push myrepo/app:latest'
                sh 'kubectl apply -f deployment.yaml'
            }
        }
    }
    
    // Post-build actions
    post {
        success {
            echo 'Pipeline succeeded!'
            // Send success notification
        }
        failure {
            echo 'Pipeline failed!'
            // Send failure notification
        }
    }
}
```

---

## Common Jenkins Features

### 1. **Webhooks** 🔗
Automatically trigger builds when code is pushed

```
GitHub webhook:
  URL: http://jenkins.example.com/github-webhook/
  Events: Push events
  
When developer pushes:
  GitHub notifies Jenkins
  Jenkins automatically starts build
```

### 2. **Stages** 📊
Each pipeline has multiple stages:

```
- Checkout    (Get source code)
- Build       (Compile code)
- Test        (Run tests)
- Deploy      (Push to production)
- Verify      (Smoke testing)
```

### 3. **Parallel Execution** ⚡
Run multiple stages simultaneously:

```
parallel(
    'Test' {
        sh 'mvn test'
    },
    'Lint' {
        sh 'eslint src/**'
    },
    'Build' {
        sh 'mvn package'
    }
)
```

### 4. **Notifications** 📧

```groovy
post {
    success {
        // Send Slack notification
        slackSend(
            channel: '#deployments',
            message: 'Build successful!',
            color: 'good'
        )
        
        // Send email
        emailext(
            subject: 'Build Success',
            body: 'Build succeeded',
            to: 'team@example.com'
        )
    }
    failure {
        slackSend(
            channel: '#deployments',
            message: 'Build failed!',
            color: 'danger'
        )
    }
}
```

---

## Integration with Docker

```groovy
stage('Build Docker Image') {
    steps {
        script {
            // Build Docker image
            sh '''
                docker build -t myapp:${BUILD_NUMBER} .
                docker tag myapp:${BUILD_NUMBER} myapp:latest
            '''
        }
    }
}

stage('Push to Registry') {
    steps {
        script {
            sh '''
                docker login -u $DOCKER_USER -p $DOCKER_PASS
                docker push myapp:${BUILD_NUMBER}
                docker push myapp:latest
            '''
        }
    }
}
```

---

## Integration with Kubernetes

```groovy
stage('Deploy to Kubernetes') {
    steps {
        script {
            sh '''
                kubectl set image deployment/myapp-deployment \
                    myapp=myapp:${BUILD_NUMBER} \
                    -n production
                
                kubectl rollout status deployment/myapp-deployment \
                    -n production
            '''
        }
    }
}
```

---

## Real-World Pipeline: Paytm-like Service

```groovy
pipeline {
    agent any
    
    environment {
        REGISTRY = 'docker.io'
        IMAGE_NAME = 'paytm-app'
        DOCKER_CREDENTIALS = credentials('docker-hub-credentials')
    }
    
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/company/paytm-app.git'
            }
        }
        
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('Code Quality Check') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    sh '''
                        docker build -t ${REGISTRY}/${IMAGE_NAME}:${BUILD_NUMBER} .
                        docker tag ${REGISTRY}/${IMAGE_NAME}:${BUILD_NUMBER} \
                                   ${REGISTRY}/${IMAGE_NAME}:latest
                    '''
                }
            }
        }
        
        stage('Push to Docker Hub') {
            steps {
                script {
                    sh '''
                        echo $DOCKER_CREDENTIALS_PSW | docker login -u $DOCKER_CREDENTIALS_USR --password-stdin
                        docker push ${REGISTRY}/${IMAGE_NAME}:${BUILD_NUMBER}
                        docker push ${REGISTRY}/${IMAGE_NAME}:latest
                    '''
                }
            }
        }
        
        stage('Deploy to Staging') {
            steps {
                script {
                    sh '''
                        kubectl set image deployment/paytm-staging \
                            paytm-app=${REGISTRY}/${IMAGE_NAME}:${BUILD_NUMBER} \
                            -n staging
                        
                        kubectl rollout status deployment/paytm-staging -n staging
                    '''
                }
            }
        }
        
        stage('Smoke Test') {
            steps {
                sh '''
                    curl -f http://staging-paytm.example.com/health || exit 1
                    echo "Health check passed!"
                '''
            }
        }
        
        stage('Deploy to Production') {
            when {
                branch 'main'
            }
            steps {
                script {
                    sh '''
                        kubectl set image deployment/paytm-production \
                            paytm-app=${REGISTRY}/${IMAGE_NAME}:${BUILD_NUMBER} \
                            -n production
                        
                        kubectl rollout status deployment/paytm-production -n production
                    '''
                }
            }
        }
    }
    
    post {
        success {
            slackSend(
                channel: '#deployments',
                message: 'Build ${BUILD_NUMBER} deployed successfully! 🚀',
                color: 'good'
            )
        }
        failure {
            slackSend(
                channel: '#deployments',
                message: 'Build ${BUILD_NUMBER} failed! ❌',
                color: 'danger'
            )
            emailext(
                subject: 'Jenkins Build Failed',
                body: 'Build failed. Check logs: ${BUILD_URL}',
                to: 'team@paytm.com'
            )
        }
    }
}
```

---

## Jenkins Benefits

✅ **Automation**: Manual tasks become automatic  
✅ **Consistency**: Same process every time  
✅ **Speed**: Faster releases (CI/CD)  
✅ **Quality**: Automated testing catches bugs early  
✅ **Reliability**: Reduced human errors  
✅ **Visibility**: Track build history  
✅ **Scalability**: Distributed agents for parallel builds

---

## Common Jenkins Plugins

| Plugin | Purpose |
|--------|---------|
| **Git Plugin** | Git integration |
| **Docker Plugin** | Docker image building/pushing |
| **Kubernetes Plugin** | Kubernetes deployment |
| **SonarQube Plugin** | Code quality analysis |
| **Slack Plugin** | Slack notifications |
| **Pipeline Plugin** | Jenkins Pipeline support |
| **Blue Ocean** | Better UI for pipelines |

---

## Key Takeaway 🎯

**Jenkins = Automated software delivery**

Makes developers' lives easier by:
1. **Automate** repetitive tasks
2. **Test** continuously
3. **Deploy** faster
4. **Monitor** build health

From code push to production in minutes! ⚡
