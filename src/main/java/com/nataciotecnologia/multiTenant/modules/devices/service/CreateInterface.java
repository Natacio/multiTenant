package com.nataciotecnologia.multiTenant.modules.devices.service;

import com.nataciotecnologia.multiTenant.modules.devices.Dto.PostInterfaceDto;
import com.nataciotecnologia.multiTenant.modules.devices.model.Devices;
import com.nataciotecnologia.multiTenant.modules.devices.model.InterfacesDevice;
import com.nataciotecnologia.multiTenant.modules.devices.repository.DeviceInterfaceRepository;
import com.nataciotecnologia.multiTenant.modules.devices.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateInterface {
    private final DeviceInterfaceRepository deviceInterfaceRepository;
    private final DeviceRepository deviceRepository;

    public CreateInterface(DeviceInterfaceRepository deviceInterfaceRepository, DeviceRepository deviceRepository) {
        this.deviceInterfaceRepository = deviceInterfaceRepository;
        this.deviceRepository = deviceRepository;
    }

    public InterfacesDevice execute(PostInterfaceDto interfacesDevice){
        Devices device = deviceRepository.findById(interfacesDevice.getDevice()).orElse(null);

        if(device == null) throw new Error("Device not found");

        InterfacesDevice d = new InterfacesDevice();
        d.setDevice(device);
        d.setTopic(interfacesDevice.getTopic());

        return deviceInterfaceRepository.save(d);
    }
}
