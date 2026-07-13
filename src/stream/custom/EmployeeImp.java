package stream.custom;

import java.util.*;
import java.util.stream.Collectors;


public class EmployeeImp {
    public static void main(String[] args) {
       List<Employee>  employees = Arrays.asList(
               new Employee("Anand",101,"Developer",78975.78),
               new Employee("Sthita",102,"Developer",78798.89),
               new Employee("Sandeep",103,"Tester",8798.90),
               new Employee("Swati",104,"DevopsEngineer",79879.90)
       );

      Optional<Double> secondHighestSalary= employees.stream()
               .map(Employee::getSalary)
               .sorted(Comparator.reverseOrder())
               .skip(1)
               .findFirst();
        System.out.println(secondHighestSalary);

//        Group employees by department
        Set<Map.Entry<String, List<Employee>>> entries = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)).entrySet();
        System.out.println(entries);
//        Employees with salary greater than department average
        Map<String, Double> deptAvg = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
       List<Employee>result= employees.stream()
                    .filter(employee -> employee.getSalary()>deptAvg.get(employee.getDepartment()))
                .collect(Collectors.toList());
        System.out.println(result);


//        Build a Map of id to employee name
        Map<Integer, String> collect = employees.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(collect);

//        Get the top 3 highest paid employees
        List<Employee> limit = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).toList();
        System.out.println(limit);

//        Given Employee list:
//        Group by department
//        Filter departments with at least 3 employees
//        Sort by salary descending (single stream pipeline)
        Map<String, List<Employee>> collect1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().stream()
                .filter(e -> e.getValue().size() >= 3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e->e.getValue().stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .collect(Collectors.toList())));
        System.out.println(collect1);
    }
}
