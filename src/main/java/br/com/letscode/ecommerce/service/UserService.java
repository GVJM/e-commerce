package br.com.letscode.ecommerce.service;

import br.com.letscode.ecommerce.model.entity.UserEntity;
import br.com.letscode.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    public void createUser(UserEntity user){
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }
}
