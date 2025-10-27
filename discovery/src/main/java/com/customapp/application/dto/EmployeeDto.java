package com.customapp.application.dto;

import com.customapp.application.model.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EmployeeDto implements Serializable {
    private Long id;
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @Valid
    private UserDto user;

    private List<AddressDto> addressList;
}
