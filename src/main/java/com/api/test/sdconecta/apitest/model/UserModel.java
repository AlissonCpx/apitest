package com.api.test.sdconecta.apitest.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserModel {

    @Id
    @GeneratedValue()
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column
    private String surname;
    @Column
    private String mobile_phone;

    @OneToMany
    private List<CrmModel> crms = new ArrayList<>();

}
