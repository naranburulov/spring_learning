package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //find all courses by category
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //Check if a course with supplied name exists. Return true/false.
    boolean existsByName(String name);

    //Returns the count of courses for the given category
    int countByCategory(String category);

    //finds all the courses that start with the given name string
    List<Course> findCourseByNameStartingWith (String name);

    //find all by courses by category and returns a stream
    Stream<Course> streamAllByCategory(String category);



    @Query("select c from Course c where c.id=1")
    Course retrieveCourseDetails(int id);


    @Query("SELECT c FROM Course c WHERE c.category = :category AND c.rating > :rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);

}
