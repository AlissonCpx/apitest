package com.api.test.sdconecta.apitest.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name = "seqcrmmodel", allocationSize = 1, sequenceName = "seqcrmmodel")
public class CrmModel extends BaseEntity {

    @Id
    @GeneratedValue(generator = "seqcrmmodel" ,strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String crm;
    @Column(nullable = false)
    private String uf;
    @Column
    private String specialty;
}
