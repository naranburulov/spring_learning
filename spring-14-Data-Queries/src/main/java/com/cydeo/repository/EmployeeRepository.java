package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Display all employees with email address
    List<Employee> findByEmail(String email);

    //Display all employees with firstName "" and lastName ""
    //also show all employees with email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees with firstName is not ""
    List<Employee> findByFirstNameIsNot (String firstName);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartingWith (String lastName);

    //Display all employees with salary higher than ""
    List<Employee> findBySalaryGreaterThan (Integer salary);
    //Display all employees with salary less than ""
    List<Employee> findBySalaryLessThan (Integer salary);

    //Display all employees who was hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate date1, LocalDate date2);

    //Display all employees where salaries greater and equal to "" in order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();


    //  Not Equal <>
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //  Like/Contains/StartsWith/EndsWith
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //  Less Than

    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //Greater Than
    @Query("select e.firstName from Employee e where e.salary > ?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    //  Between

    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //  Before
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //  Null
    @Query("select e from Employee e where e.email is null")
    List<Employee> retrieveEmployeeEmailIsNull();

    //  Not Null
    @Query("select e from Employee e where e.email is not null")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //  Sorting in ascending order
    @Query("select e from Employee e order by e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //  Sorting in descending order
    @Query("select e from Employee e order by e.salary desc")
    List<Employee> retrieveEmployeeSalaryOrderDesc();


    ///////////////////////////////////////////////////////////////////////////////

    //NATIVE QUERIES
    @Query(value = "select * from employees where salary =?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);


    //Named Parameter
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);







}
