package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
// similar to @JsonIgnore, but at the class level, not the field
//@JsonIgnoreProperties(value = {"address", "country"}, ignoreUnknown = true)
@JsonIgnoreProperties(ignoreUnknown = true) //will ignore unknown fields - good practice, to save running time
public class AccountDTO {

    @JsonIgnore
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;

    @JsonBackReference          //hides UserDTO (this field is not going to be serialized)
    private UserDTO user;

}
