package com.example.ecommerceapi.model.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "api_status")
public class ApiStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    UserSchema user;

    @Column(columnDefinition = "boolean default true")
    private boolean status = true;
}
