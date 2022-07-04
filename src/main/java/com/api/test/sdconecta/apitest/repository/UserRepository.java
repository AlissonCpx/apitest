package com.api.test.sdconecta.apitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.api.test.sdconecta.apitest.model.UserModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    public Optional<UserModel> findByEmail(String email);

    public Optional<List<UserModel>> findByName(String name);

   @Query(value = "SELECT u FROM UserModel u INNER JOIN u.crms c WHERE c.specialty = ?1")
    public List<UserModel> findBySpecielty(String specielty);

    public Optional<UserModel> findByAdmin(Boolean bool);

}
