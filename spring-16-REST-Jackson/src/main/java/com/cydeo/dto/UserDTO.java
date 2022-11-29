package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)       //property means a field;
    // here it means user can read, but not write
    private String password;
    private String username;
    private UserRole role;

    @JsonManagedReference               //show AccDTO in UserDTO (this field is going to be serialized)
    private AccountDTO account;

}
