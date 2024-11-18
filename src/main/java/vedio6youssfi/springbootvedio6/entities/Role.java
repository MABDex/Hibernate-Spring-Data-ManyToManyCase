package vedio6youssfi.springbootvedio6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor



public class Role {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String descr; // discription

    @Column(length = 20 , unique=true)
    private String rolename;

    @ManyToMany (fetch = FetchType.EAGER)
    // @JoinTable (name = "Users_Role")    //

    private List<User> users = new ArrayList<>();





}
