package com.nataciotecnologia.multiTenant.modules.user.Dto;

import com.nataciotecnologia.multiTenant.modules.user.model.UserModel;
import lombok.Data;

import java.util.UUID;

@Data
public class ResponseUserDto {
    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private String db;
    private Boolean admin ;

    public ResponseUserDto(UserModel user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.db = user.getDb();
        this.admin = user.getAdmin();
    }
}
