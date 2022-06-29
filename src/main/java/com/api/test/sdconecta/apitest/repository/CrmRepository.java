package com.api.test.sdconecta.apitest.repository;

import com.api.test.sdconecta.apitest.model.CrmModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrmRepository extends JpaRepository<CrmModel, Long> {
}
