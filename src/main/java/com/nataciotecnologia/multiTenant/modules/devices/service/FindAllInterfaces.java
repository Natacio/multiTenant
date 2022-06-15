package com.nataciotecnologia.multiTenant.modules.devices.service;

import com.nataciotecnologia.multiTenant.modules.devices.model.InterfacesDevice;
import com.nataciotecnologia.multiTenant.modules.devices.repository.DeviceInterfaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllInterfaces {
    private final DeviceInterfaceRepository deviceInterfaceRepository;

    public FindAllInterfaces(DeviceInterfaceRepository deviceInterfaceRepository) {
        this.deviceInterfaceRepository = deviceInterfaceRepository;
    }

    public List<InterfacesDevice> execute(){
        return this.deviceInterfaceRepository.findAll();
    }
}
