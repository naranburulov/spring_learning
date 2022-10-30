package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//all the annotations are the sql codes behind the scenes,
// so that Postgres could perform behind the scenes
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //create id by postgres
    private Long id;
    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    private String email;

    @Column(columnDefinition = "Date")  //creates Postgres Data Types
    private LocalDate birthDate;
    @Column(columnDefinition = "Time")
    private LocalTime localTime;
    @Column(columnDefinition = "TimeStamp")
    private LocalDateTime birthDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient                      //hides(ignores) the certain field from the table
    private String city;


}
