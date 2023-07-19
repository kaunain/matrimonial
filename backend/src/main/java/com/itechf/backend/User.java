package com.itechf.backend;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private Integer height;

    private String maritalStatus;

    private String religion;

    private String caste;

    private String motherTongue;

    private String educationLevel;

    private String occupation;

    private Integer annualIncome;

    private String fatherName;

    private String motherName;

    private Integer numberOfSiblings;

    private String familyBackground;

    private String nativePlace;

    private String address;

    private String city;

    private String state;

    private String country;
}
