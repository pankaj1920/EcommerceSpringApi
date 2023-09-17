package com.example.ecommerceapi.model.entites;

import com.example.ecommerceapi.model.other.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class UserSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int id;

    private String firstName;
    private String lastName;
    private Date dob;
    private int countryCode;

    @Column(length = 10,unique = true)
    private int mobile;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String email;

    private String password;
    private String otp;
    private String profileImage;
    @Column(columnDefinition = "VARCHAR(5) DEFAULT 'en'")
    private String language = "en";

    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private ApiStatus apiStatus;


}
