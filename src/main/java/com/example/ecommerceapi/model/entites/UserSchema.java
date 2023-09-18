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
    @Column(name = "id", nullable = false)
     private int id;
    private String firstName;
    private String lastName;
    private Date dob;

    @Column(name = "country_code", length = 5)
    private int countryCode;

    @Column(name = "mobile")
    private int mobile;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "email")
    private String email;

    private String password;
    private String otp;
    private String profileImage;

    @Column(name = "language",columnDefinition = "VARCHAR(5) DEFAULT 'en'")
    private String language = "en";

    @Column(name = "created_at",updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private ApiStatus apiStatus;


}
