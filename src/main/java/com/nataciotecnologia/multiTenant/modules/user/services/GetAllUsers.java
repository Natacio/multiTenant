package com.nataciotecnologia.multiTenant.modules.user.services;

import com.nataciotecnologia.multiTenant.modules.user.Dto.ResponseUserDto;
import com.nataciotecnologia.multiTenant.modules.user.model.UserModel;
import com.nataciotecnologia.multiTenant.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllUsers {
    @Autowired
    private UserRepository userRepository;

    public List<ResponseUserDto> execute(){
        List<UserModel> users = this.userRepository.findAll();
       return users.stream().map(ResponseUserDto::new).collect(Collectors.toList());
    }
}
