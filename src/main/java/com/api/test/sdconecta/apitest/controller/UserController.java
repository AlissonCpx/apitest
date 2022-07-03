package com.api.test.sdconecta.apitest.controller;

import com.api.test.sdconecta.apitest.model.CrmModel;
import com.api.test.sdconecta.apitest.model.UserModel;
import com.api.test.sdconecta.apitest.repository.CrmRepository;
import com.api.test.sdconecta.apitest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CrmRepository crmRepository;

    @GetMapping
    public List<UserModel> listAll() {
        List<UserModel> users = userRepository.findAll();
        return users;
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserModel user) {
        try {
            List<CrmModel> crms = crmRepository.saveAll(user.getCrms());
            user.setCrms(crms);
            return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserModel user) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(userRepository.save(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

}
