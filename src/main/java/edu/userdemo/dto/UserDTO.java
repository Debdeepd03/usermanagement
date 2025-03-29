package edu.userdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//this is a DTO replicating User.class and object of this class will be travelling across the
// multiple layers of the packages.
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class UserDTO {
    private Integer id;
    private String name;
    private String email;

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
