package com.jsp.osa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {



     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int userId;

    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean verified;
//    private Role role;
    private boolean isDelete;


}
