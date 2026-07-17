package com.gautamthapa.coding;

import com.gautamthapa.util.Employee;
import com.gautamthapa.util.Util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPI {
    static void main(String[] args) {
        List<Employee> employees = Util.getEmployees();
        int[] arr1 = {1, 2, 3, 4, 5, 6, 8, 2, 1};

        //================================================================
        // Arrays.stream(array) - Creates a sequential stream from an array
        List<Integer> evenNums = Arrays.stream(arr1)
                .filter(value -> value % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Event Numbers: ");
        evenNums.forEach(System.out::println);
        //================================================================

        //================================================================
        // map - Transforms elements - One input → One output
        List<Integer> squares = Arrays.stream(arr1)
                .map(num -> num * num)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Square Numbers: ");
        squares.forEach(System.out::println);

        // mapToInt - To avoid boxing/unboxing overhead, Java provides specialized mapping methods:
        int totalSalary = employees.stream()
                .mapToInt(emp -> emp.getSalary().intValue())
                .sum();
        System.out.println("totalSalary: " + totalSalary);
        //================================================================


        //================================================================
        // sum()
        int totalSum = Arrays.stream(arr1)
                .sum();
        System.out.println("totalSum: " + totalSum);
        //================================================================


        //================================================================
        // filter() - It is an intermediate operation that selects elements from a stream based on a condition.
        List<Integer> oddNumbers = Arrays.stream(arr1)
                .filter(num -> num % 2 != 0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("oddNumbers: " + oddNumbers);
        //================================================================


        //================================================================
        //sorted() - sorted() returns a new stream with the elements sorted.
        // There are two overloaded methods:
        //1. Stream<T> sorted() - Uses the natural ordering of elements.
        List<Integer> sortedNumbers = Arrays.stream(arr1)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        System.out.println("sortedNumbers: " + sortedNumbers);

        //2. Stream<T> sorted(Comparator<? super T> comparator) - Uses a custom Comparator.
        List<Employee> sortedBasedOnSalary = employees
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("sortedBasedOnSalary: " + sortedBasedOnSalary);


        // Collections.sort() - Works on Lists, Modifies the original list, Standalone operation
        List<Integer> inputAsList = Arrays.stream(arr1)
                .boxed().collect(Collectors.toList());
        Collections.sort(inputAsList);
        System.out.println("inputAsList : " + inputAsList);
        //================================================================


        //================================================================
        // Comparator - A Comparator is a functional interface used to define custom sorting logic for objects.
        // Method - int compare(T o1, T o2); - Negative (< 0) → o1 comes before o2, Zero (0) → Both are equal, Positive (> 0) → o1 comes after o2

        //1. comparing() - Sort by a specific field.
        List<Employee> sortBySalaryAsc = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)).toList();
        System.out.println("sortBySalaryAsc : " + sortBySalaryAsc);

        //2. reversed() - Reverse the sorting order in comparator
        List<Employee> sortBySalaryDesc = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
        System.out.println("sortBySalaryDesc : " + sortBySalaryDesc);

        //3. thenComparing() - Sort by multiple fields.
        List<Employee> sortBySalaryDeptAsc = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getDepartment)).toList();
        System.out.println("sortBySalaryDeptAsc : " + sortBySalaryDeptAsc);

        //3. reverseOrder() - For natural types.
        List<Integer> numsDesc = Arrays.stream(arr1)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("numsDesc : " + numsDesc);

        //4. naturalOrder() - Ascending order.
        List<Integer> numsAsc = Arrays.stream(arr1)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .toList();
        System.out.println("numsAsc : " + numsAsc);

        //5. nullsFirst()
        List<String> strings = new ArrayList<>();
        strings.add("John");
        strings.add(null);
        strings.add("Sanjeev");

        List<String> nullFirst = strings.stream()
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder())).toList();
        System.out.println("nullFirst : " + nullFirst);

        //5. nullsLast()
        List<String> nullLast = strings.stream()
                .sorted(Comparator.nullsLast(Comparator.naturalOrder())).toList();
        System.out.println("nullFirst : " + nullFirst);

        //6. comparingInt(), comparingLong(), comparingDouble()
        // Comparator.comparingLong(Employee::getId)

        //================================================================


        //================================================================
        // max() - Returns the largest element according to the provided comparator. - Terminal Operation
        // Optional<T> max(Comparator<? super T> comparator)
        //Integer maxNumber=Arrays.stream(arr1).max(Comparator.naturalOrder());
        Employee highestSalary = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
        System.out.println("highestSalary : " + highestSalary);

        // Longest String
        List<String> names = List.of("Java", "Spring Boot", "Kafka");
        String longestName = names.stream().max(Comparator.comparing(String::length)).orElse(null);
        System.out.println("longestName : " + longestName);
        //================================================================

        //================================================================
        // min() - Returns the smallest element according to the comparator.
        // Optional<T> min(Comparator<? super T> comparator)

        // min number
        Integer minNum = Arrays.stream(arr1).boxed().min(Integer::compareTo).orElse(-1);
        System.out.println("minNum : " + minNum);

        // Min Employee by Salary
        Employee minSalaryEmp = employees.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println("minSalaryEmp : " + minSalaryEmp);

        // Shortest String
        String[] names1 = {"John", "Gtm", "Lx"};
        String shortestName = Arrays.stream(names1).min(Comparator.comparing(String::length)).orElse(null);
        System.out.println("shortestName : " + shortestName);

        //NOTE: if we need to find out largest employee salary/largest number and lowest salary employee/number then we use min() and max rather than sorted
        //================================================================


        //================================================================
        // collect() - collect() is a terminal operation of the Stream API.
        // It is used to accumulate (collect) the elements of a stream into a final result, such as: List, Map, Set, String, Statics, Grouped data, partitioned data
        // <R, A> R collect(Collector<? super T, A, R> collector)

        // Collectors - Collectors is a utility class (java.util.stream.Collectors) that provides many predefined implementations of the Collector interface.
        // ** collect() performs the collection, while Collectors tells it how to collect. **
        // collect() → Terminal operation
        // Collectors.toList() → Strategy for collecting

        // Methods
        // toList() - Convert stream to List.
        List<Integer> arrList = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        System.out.println("arrList : " + arrList);

        // toMap() - Convert stream to Map.
        Map<String, Double> empSalaryMap = employees.stream().collect(Collectors.toMap(Employee::getFirstName, Employee::getSalary));
        System.out.println("empSalaryMap : " + empSalaryMap);

        // toSet() - Remove duplicates.
        Set<Integer> uniqueNumbers = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        System.out.println("uniqueNumbers : " + uniqueNumbers);

        // joining() - Convert multiple strings into one.
        String[] vowels = {"A", "E", "I", "O", "U"};
        String vowelsString = Arrays.stream(vowels).collect(Collectors.joining(""));
        System.out.println("vowelsString : " + vowelsString);

        // counting() - Count elements.
        long empCount = employees.stream().collect(Collectors.counting());
        long empCount1 = employees.stream().count();
        System.out.println("empCount : " + empCount + "==" + empCount1);


        // groupingBy() **** IMP - One of the most asked interview questions.
        // Group employees by department.
        Map<String, List<Employee>> empByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("empByDept : " + empByDept);

        // partitioningBy() - Splits data into exactly two groups.
        Map<Boolean, List<Employee>> empSalaryGreaterThan50000 = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 50000.00));
        System.out.println("empSalaryGreaterThan50000 : " + empSalaryGreaterThan50000);


        // mapping() - Transform values while grouping.
        Map<String, List<String>> getEmpsByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getFirstName, Collectors.toList())));
        System.out.println("getEmpsByDept : " + getEmpsByDept);

        // averagingInt()
        double averageSalary = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("averageSalary : " + averageSalary);

        double totalSalariesOfAllEmp = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        // OR
        double totalSalariesOfAllEmp1 = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("totalSalariesOfAllEmp : " + totalSalariesOfAllEmp + "==" + totalSalariesOfAllEmp1);


        // maxBy(), minBy
        Employee maxSalaryEmp = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).orElse(null);
        // OR
        Employee maxSalaryEmp1 = employees.stream()
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println("maxSalaryEmp : " + maxSalaryEmp + "==" + maxSalaryEmp1);


        // summarizingInt()
        IntSummaryStatistics summaryStat = employees.stream().collect(Collectors.summarizingInt(value -> value.getSalary().intValue()));
        System.out.println(summaryStat.getCount());
        System.out.println(summaryStat.getSum());
        System.out.println(summaryStat.getAverage());
        System.out.println(summaryStat.getMax());
        System.out.println(summaryStat.getMin());


        // Interview Questions
        //1. Find highest salary employee
        Employee highestSalaryEmp = employees.stream()
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println("highestSalaryEmp : " + highestSalaryEmp);

        //2. Count employees department wise
        Map<String, Long> employeesCountDeptWise = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("employeesCountDeptWise : " + employeesCountDeptWise);

        //3. Average salary department wise
        Map<String, Double> averageSalaryDeptWise = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("averageSalaryDeptWise : " + averageSalaryDeptWise);


        //================================================================


        //================================================================
        // IntStream - IntStream is a specialized Stream for primitive int values.
        // Instead of using Stream<Integer>, which involves boxing (int → Integer) and unboxing (Integer → int), IntStream works directly with primitive integers.

        // Without IntStream
        List<Integer> list = List.of(1, 2, 3);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum : " + sum);

        // With IntStream - It is better on primitive int
        int sum1 = Arrays.stream(arr1).sum();
        System.out.println("sum1 : " + sum1);

        // Methods of IntStream
        // range() - Generates numbers from start (inclusive) to end (exclusive).
        IntStream.range(0, 10).forEach(System.out::println);

        //rangeClosed() - Includes the last number.
        IntStream.rangeClosed(0, 10).forEach(System.out::println);

        // of() - Create an IntStream from values.
        IntStream.of(1, 4, 5).forEach(System.out::println);

        // sum()
        int sumIntStream = IntStream.rangeClosed(1, 10).sum();
        System.out.println("sumIntStream : " + sumIntStream);

        // min() / max()
        int maxIntStream = IntStream.of(1, 4, 5).max().orElse(-1);
        System.out.println("maxIntStream : " + sumIntStream);

        // filter()
        IntStream.rangeClosed(1, 10)
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println);

        // map()
        IntStream.rangeClosed(1, 10)
                .map(value -> value * 2)
                .forEach(System.out::println);

        // boxed()
        List<Integer> integersList = IntStream.rangeClosed(1, 10)
                .boxed().collect(Collectors.toList());
        System.out.println("integersList : " + integersList);

        //================================================================


        //================================================================
        //flatMap() - Flattening nested lists - One-to-many mapping
        List<List<String>> listEx = List.of(
                List.of("Java", "Spring"),
                List.of("Kafka", "AWS")
        );
        List<String> listFlatted = listEx.stream().flatMap(Collection::stream).toList();
        System.out.println("listFlatted : " + listFlatted);

        //================================================================

        //================================================================
        // reduce() - Sum, Product, Maximum, Minimum, String Concatenation, Factorial
        int sumReduce = Arrays.stream(arr1).reduce(0, Integer::sum);
        System.out.println("sumReduce : " + sumReduce);
        //================================================================

        //================================================================
        // distinct() - remove duplicates
        List<Integer> rmvDuplicates = Arrays.stream(arr1).boxed().distinct().toList();
        System.out.println("rmvDuplicates : " + rmvDuplicates);

        //================================================================

        //================================================================
        // peek() - Mostly used for debugging.
//        List<Integer> intData =Arrays.stream(arr1).peek(System.out::println)
//                .filter(value -> value>2).toList();
        //================================================================


        //================================================================
        // limit() & skip() - Useful for pagination.
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<Integer> paginated = nums.stream().skip(10).limit(5).toList();
        System.out.println("paginated : " + paginated);
        //================================================================

        //================================================================
        // findFirst() vs findAny() - stream.findFirst(); stream.findAny();
        // anyMatch(), allMatch(), noneMatch() - stream.anyMatch(); stream.allMatch(); stream.noneMatch();
        //================================================================

        //================================================================
        // toArray();
        int[] numsArray = nums.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("numsArray : " + Arrays.toString(numsArray));
        //================================================================

    }
}
