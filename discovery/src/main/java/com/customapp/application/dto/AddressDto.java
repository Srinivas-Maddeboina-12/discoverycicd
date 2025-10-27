package com.customapp.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private Long id;
    private String addressType;
    private String street;
    private String city;
}

