package com.api.test.sdconecta.apitest.controller;

import com.api.test.sdconecta.apitest.decorator.UserAcessDecorator;
import com.api.test.sdconecta.apitest.model.UserModel;
import com.api.test.sdconecta.apitest.repository.UserRepository;
import com.api.test.sdconecta.apitest.service.SdConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;


    private final PasswordEncoder encoder;

    public LoginController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody Map<String, Optional<String>> json) {
        try {
            String email = json.get("email").get();
            String password = json.get("password").get();

            Optional<UserModel> user = userRepository.findByEmail(email);

            if (user.isPresent()) {
                SdConnectService sd = new SdConnectService();
                UserAcessDecorator userAcess = sd.validUser(user.get()).getBody();
                boolean validUser = encoder.matches(password, user.get().getPassword());
                if (validUser) {
                    return ResponseEntity.status(HttpStatus.OK).body(userAcess);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválido;");
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválido;");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }
}
