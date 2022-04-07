package br.com.letscode.ecommerce.controller;

import br.com.letscode.ecommerce.security.jwt.JWTCreator;
import br.com.letscode.ecommerce.security.jwt.JWTObject;
import br.com.letscode.ecommerce.config.SecurityConfig;
import br.com.letscode.ecommerce.model.dto.LoginDto;
import br.com.letscode.ecommerce.model.dto.SessaoDto;
import br.com.letscode.ecommerce.model.entity.UserEntity;
import br.com.letscode.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public SessaoDto logar(@RequestBody LoginDto login){
        UserEntity user = repository.findByUsername(login.getUsername());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            SessaoDto sessao = new SessaoDto();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
