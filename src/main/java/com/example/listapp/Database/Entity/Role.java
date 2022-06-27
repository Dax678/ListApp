package com.example.listapp.Database.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "role", schema = "public")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long Id;

    @Column(name = "role_name")
    private String role_name;

    @Column(name = "role_full_name")
    private String role_full_name;

    @OneToMany(mappedBy = "role")
    private List<User> user;
}
