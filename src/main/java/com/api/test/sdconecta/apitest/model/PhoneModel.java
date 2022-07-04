package com.api.test.sdconecta.apitest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PhoneModel extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String ddd;

    @Column
    private String number;

    @Column
    private String type;

}
