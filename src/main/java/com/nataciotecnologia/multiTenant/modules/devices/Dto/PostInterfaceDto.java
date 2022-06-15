package com.nataciotecnologia.multiTenant.modules.devices.Dto;


import lombok.Data;

import java.util.UUID;

@Data
public class PostInterfaceDto {
    private String topic;
    private UUID device;
}
