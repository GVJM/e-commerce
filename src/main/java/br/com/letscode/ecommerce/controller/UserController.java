package br.com.letscode.ecommerce.controller;

import br.com.letscode.ecommerce.model.entity.UserEntity;
import br.com.letscode.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping
    public void postUser(@RequestBody UserEntity user){
        service.createUser(user);
    }
}
