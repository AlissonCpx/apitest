package com.api.test.sdconecta.apitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.test.sdconecta.apitest.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {


}
