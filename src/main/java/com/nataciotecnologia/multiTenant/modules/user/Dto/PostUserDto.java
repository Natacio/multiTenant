package com.nataciotecnologia.multiTenant.modules.user.Dto;

import lombok.Data;

@Data
public class PostUserDto {
    private String name;
    private String lastname;
    private String userName;
    private String email;
    private String password;
    private String db;
    private Integer isAdmin = 0;
}
