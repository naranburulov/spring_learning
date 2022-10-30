package com.cydeo;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepositoryR, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepositoryR;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----------REGIONS-----------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("getByCountry: " + regionRepository.getByCountry("Canada"));
        System.out.println("getByCountry: " + regionRepository.findByCountryContaining("United"));
        System.out.println("getByCountry: " + regionRepository.findByCountryContainingOrderByRegion("United"));
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("United States"));

        System.out.println("-----------DEPARTMENTS----------");
        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision:" + departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionEndsWith:" + departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContains:" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("-----------EMPLOYEES----------");
        System.out.println("employee detail:" + employeeRepository.retrieveEmployeeDetail());
        System.out.println("employee salary:" + employeeRepository.retrieveEmployeeSalary());


        System.out.println("-----------COURSES----------");
        System.out.println("Courses by Category: " + courseRepository.findByCategory("Spring"));
        System.out.println("Courses by id: " + courseRepository.retrieveCourseDetails(1));

    }
}
