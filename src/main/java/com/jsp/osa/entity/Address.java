package com.jsp.osa.entity;

import com.jsp.osa.enums.AddressType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String streetAddress;
    private String streetAddressAdditional;
    private String city;
    private String state;
    private String country;
    private String pincode;

    private AddressType addressType;



}
