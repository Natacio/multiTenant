package com.nataciotecnologia.multiTenant.modules.devices.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PostLocationToInterfaceDto {
    private UUID device;
    private Long interfaceDevice;
    private Long location;
}
