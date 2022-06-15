package com.nataciotecnologia.multiTenant.modules.user.services;

import com.nataciotecnologia.multiTenant.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUser {
    @Autowired
    UserRepository userRepository;

    public void execute(UUID id){
        userRepository.deleteById(id);
    }
}
