package com.api.test.sdconecta.apitest.controller;

import com.api.test.sdconecta.apitest.model.UserModel;
import com.api.test.sdconecta.apitest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UserController() {
    }

    @GetMapping
    public List<UserModel> listAll() {
        List<UserModel> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/name={name}")
    public ResponseEntity listAllByName(@PathVariable("name") String name) {
        if (name.isEmpty()) {
            List<UserModel> users = userRepository.findByName(name).get();
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado nenhum usuário com nome de " + name);
    }

    @GetMapping("/specialty={specialty}")
    public ResponseEntity listAllBySpecialty(@PathVariable("specialty") String specialty) {
        if (specialty.isEmpty()) {
            List<UserModel> users = userRepository.findBySpecielty(specialty);
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
    }


    @PostMapping
    public ResponseEntity addUser(@RequestBody UserModel user) {
        try {
            user.setPassword(encoder.encode(user.getPassword()));
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

    @GetMapping("/getUser")
    public ResponseEntity getUser(@RequestParam Long id) {
        try {
            Optional<UserModel> user = userRepository.findById(id);
            if (user.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado usuário;");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam Long id) {
        try {
            Optional<UserModel> user = userRepository.findById(id);
            if (user.isPresent()) {
                userRepository.delete(user.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado usuário;");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado;");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @PostConstruct
    public void addAdmin() {
        Optional<UserModel> userAdmin = userRepository.findByAdmin(true);
        if (!userAdmin.isPresent()) {
            UserModel user = new UserModel();
            user.setEmail("Admin@email.com");
            user.setName("Admin");
            user.setPassword(encoder.encode("admin"));
            user.setCrms(new ArrayList<>());
            user.setMobile_phones(new ArrayList<>());
            user.setAdmin(true);
            userRepository.save(user);
        }
    }
}
