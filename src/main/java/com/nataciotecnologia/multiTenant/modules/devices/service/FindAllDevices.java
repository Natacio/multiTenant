package com.nataciotecnologia.multiTenant.modules.devices.service;

import com.nataciotecnologia.multiTenant.modules.devices.model.Devices;
import com.nataciotecnologia.multiTenant.modules.devices.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllDevices {
    private final DeviceRepository deviceRepository;

    public FindAllDevices(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Devices> execute(){
        return deviceRepository.findAll();
    }
}
