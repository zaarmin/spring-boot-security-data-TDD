package com.azadi.model.dto;


import lombok.Data;
import javax.validation.constraints.NotNull;



@Data
public class LoginDto {

    @NotNull
    private String username;

    @NotNull
    private String password ;

    private String firstName;

    private String lastName;

}
