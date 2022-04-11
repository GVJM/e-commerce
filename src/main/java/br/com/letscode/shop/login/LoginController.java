package br.com.letscode.shop.login;

import br.com.letscode.shop.client.UserService;
import br.com.letscode.shop.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserService service;

    @PostMapping("/login")
    public SessaoDto logar(@RequestBody LoginDto login){
        return service.login(login);
    }
}

