package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)      //not to see null fields
public class AddressDTO {

    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private AddressType addressType;


    @JsonBackReference(value = "student-address-reference")                  //defaultReference
    private StudentDTO student;

    @JsonBackReference(value = "parent-address-reference")                    //defaultReference
    private ParentDTO parent;

    @JsonBackReference(value = "teacher-address-reference")                    //defaultReference
    private TeacherDTO teacher;


    private Integer currentTemperature; //weather information, which will be consumed from 3rd part API

}