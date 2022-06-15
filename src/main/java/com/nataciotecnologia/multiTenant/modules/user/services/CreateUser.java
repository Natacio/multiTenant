package com.nataciotecnologia.multiTenant.modules.user.services;

import com.nataciotecnologia.multiTenant.modules.user.model.UserModel;
import com.nataciotecnologia.multiTenant.modules.user.Dto.PostUserDto;
import com.nataciotecnologia.multiTenant.modules.user.Dto.ResponseUserDto;
import com.nataciotecnologia.multiTenant.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {
    @Autowired
    private UserRepository userRepository;

    public ResponseUserDto execute (PostUserDto request){
        UserModel user = new UserModel();

        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUserName());
        user.setPassword(request.getPassword());
        user.setDb(request.getDb());
        this.userRepository.save(user);
        return new ResponseUserDto(user);

    }
}
