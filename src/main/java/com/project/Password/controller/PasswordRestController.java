package com.project.Password.controller;

import com.project.Password.models.PBKDF2;
import com.project.Password.models.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PasswordRestController {

    @Autowired
    private PBKDF2 pbkdf2;

    @GetMapping(value = "/{password}")
    public String encode(@PathVariable("password") String password){
        Password simplePassword = new Password().setPassword(password);
        pbkdf2.setPassword(simplePassword);
        return pbkdf2.encodePassword();
    }

}
