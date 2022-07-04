package com.api.test.sdconecta.apitest.model;


import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserModel extends BaseEntity {

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
    private String lastAuthorizationStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CrmModel> crms;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneModel> mobile_phones;

}
