package com.api.test.sdconecta.apitest.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class CrmModel extends BaseEntity {

    @Id
    @GeneratedValue()
    private Long id;
    @Column(nullable = false)
    private String crm;
    @Column(nullable = false)
    private String uf;
    @Column
    private String specialty;
}
