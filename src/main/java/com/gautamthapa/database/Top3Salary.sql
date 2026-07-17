-- ============================================
-- SQL Query: Find 3rd Highest Salary
-- ============================================

-- ❌ WRONG: This won't work correctly
-- SELECT salary FROM employee ORDER BY salary DESC LIMIT 1 OFFSET 2;
-- Problem: Returns a salary value, not guaranteed to be unique salaries


-- ✅ CORRECT: Using DISTINCT with subquery
SELECT DISTINCT salary
FROM employee e1
WHERE 3 = (
    SELECT COUNT(DISTINCT salary)
    FROM employee e2
    WHERE e2.salary >= e1.salary
);

-- ============================================
-- EXPLANATION
-- ============================================

/*
How this query works:

1. OUTER QUERY: SELECT DISTINCT salary FROM employee e1
   └─ Gets salary values from employee table
   └─ DISTINCT removes duplicates

2. WHERE 3 = (...)
   └─ Only select salaries where the count equals 3

3. INNER QUERY: COUNT(DISTINCT salary) FROM employee e2 WHERE e2.salary >= e1.salary
   └─ For each salary in e1, count HOW MANY distinct salaries are >= that salary

   Example:
   Salaries: 100, 200, 300, 400, 500

   When e1.salary = 500 (highest):
     └─ Salaries >= 500: {500}
     └─ COUNT(DISTINCT) = 1

   When e1.salary = 400:
     └─ Salaries >= 400: {400, 500}
     └─ COUNT(DISTINCT) = 2

   When e1.salary = 300 (3RD HIGHEST):
     └─ Salaries >= 300: {300, 400, 500}
     └─ COUNT(DISTINCT) = 3  ✅ MATCH! This is our answer

   When e1.salary = 200:
     └─ Salaries >= 200: {200, 300, 400, 500}
     └─ COUNT(DISTINCT) = 4

   When e1.salary = 100:
     └─ Salaries >= 100: {100, 200, 300, 400, 500}
     └─ COUNT(DISTINCT) = 5
*/

-- ============================================
-- WHAT DOES "1" AT THE END MEAN?
-- ============================================

/*
The "1" is not actually in the main query - it's part of the WHERE clause logic

But if you see something like:
    WHERE 1 = (SELECT COUNT(...))

That means: WHERE the count equals 1

For example:
    WHERE 1 = (...) means we want the HIGHEST salary
    WHERE 2 = (...) means we want the 2nd HIGHEST salary
    WHERE 3 = (...) means we want the 3rd HIGHEST salary
*/

-- ============================================
-- ALTERNATIVE SOLUTIONS
-- ============================================

-- Solution 2: Using LIMIT and OFFSET (Simpler)
SELECT DISTINCT salary
FROM employee
ORDER BY salary DESC
    LIMIT 1 OFFSET 2;
-- OFFSET 2 means skip first 2 (highest and 2nd highest), get the 3rd

-- Solution 3: Using ROW_NUMBER() (Modern SQL)
WITH ranked_salaries AS (
    SELECT
        salary,
        ROW_NUMBER() OVER (ORDER BY salary DESC) as rank
    FROM (
             SELECT DISTINCT salary FROM employee
         ) unique_salaries
)
SELECT salary FROM ranked_salaries WHERE rank = 3;

-- Solution 4: Using DENSE_RANK()
WITH ranked_salaries AS (
    SELECT
        salary,
        DENSE_RANK() OVER (ORDER BY salary DESC) as rank
    FROM employee
)
SELECT salary
FROM ranked_salaries
WHERE rank = 3
    LIMIT 1;

-- ============================================
-- PERFORMANCE COMPARISON
-- ============================================

/*
1. DISTINCT with Subquery:
   └─ Pros: Works in all SQL databases, good with multiple duplicate salaries
   └─ Cons: More complex, O(n²) in worst case

2. LIMIT OFFSET:
   └─ Pros: Simple and readable
   └─ Cons: Doesn't handle ties well, might miss if same salary appears

3. ROW_NUMBER/DENSE_RANK:
   └─ Pros: Most efficient, works with window functions
   └─ Cons: Not available in older SQL versions

For large datasets: Use ROW_NUMBER/DENSE_RANK
For simplicity: Use LIMIT OFFSET
For correctness: Use DISTINCT with subquery
*/

-- ============================================
-- TEST DATA
-- ============================================

CREATE TABLE employee (
                          emp_id INT,
                          emp_name VARCHAR(50),
                          salary INT
);

INSERT INTO employee VALUES
                         (1, 'Alice', 50000),
                         (2, 'Bob', 60000),
                         (3, 'Charlie', 60000),    -- Duplicate salary
                         (4, 'David', 70000),
                         (5, 'Eve', 80000),
                         (6, 'Frank', 80000);      -- Duplicate salary

-- Running the query:
-- Expected output: 60000
-- Because: 80000 (1st), 70000 (2nd), 60000 (3rd)