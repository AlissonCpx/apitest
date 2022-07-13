package com.api.test.sdconecta.apitest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(name = "seqphonemodel", allocationSize = 1, sequenceName = "seqphonemodel")
public class PhoneModel extends BaseEntity {

    @Id
    @GeneratedValue(generator = "seqphonemodel",strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String ddd;
    @Column
    private String number;
    @Column
    private String type;

}
