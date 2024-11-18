package vedio6youssfi.springbootvedio6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor




public class User {

    @Id
    private String userid;

    @Column(name = "User_Name" , unique=true)//C'est un index unique : on ne peut pas avoir deux fois le même nom d'utilisateur
    private String username;

    private String password;
    @ManyToMany (mappedBy = "users" , fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();






}
