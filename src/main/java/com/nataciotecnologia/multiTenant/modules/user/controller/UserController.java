package com.nataciotecnologia.multiTenant.modules.user.controller;

import com.nataciotecnologia.multiTenant.modules.user.Dto.PostUserDto;
import com.nataciotecnologia.multiTenant.modules.user.Dto.ResponseUserDto;
import com.nataciotecnologia.multiTenant.modules.user.services.CreateUser;
import com.nataciotecnologia.multiTenant.modules.user.services.DeleteUser;
import com.nataciotecnologia.multiTenant.modules.user.services.GetAllUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private GetAllUsers getAllUsers;

    @Autowired
    private CreateUser createUser;

    @Autowired
    private DeleteUser deleteUser;

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> getAll(){
        try {
            return ResponseEntity.ok().body(this.getAllUsers.execute());
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ResponseUserDto> create(@RequestBody PostUserDto user){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.createUser.execute(user));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){

        try {
            this.deleteUser.execute(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
