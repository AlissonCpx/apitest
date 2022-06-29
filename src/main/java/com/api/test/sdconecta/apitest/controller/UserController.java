package com.api.test.sdconecta.apitest.controller;

import com.api.test.sdconecta.apitest.model.CrmModel;
import com.api.test.sdconecta.apitest.model.UserModel;
import com.api.test.sdconecta.apitest.repository.CrmRepository;
import com.api.test.sdconecta.apitest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel addUser(@RequestBody UserModel user) {
        List<CrmModel> crms = crmRepository.saveAll(user.getCrms());
        user.setCrms(crms);

        return userRepository.save(user);
    }

}
