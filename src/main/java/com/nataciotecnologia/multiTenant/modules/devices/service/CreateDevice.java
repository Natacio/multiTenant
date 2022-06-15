package com.nataciotecnologia.multiTenant.modules.devices.service;

import com.nataciotecnologia.multiTenant.modules.devices.model.Devices;
import com.nataciotecnologia.multiTenant.modules.devices.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateDevice {
    private final DeviceRepository deviceRepository;

    public CreateDevice(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Devices execute (Devices device){
      return this.deviceRepository.save(device);
    }
}
