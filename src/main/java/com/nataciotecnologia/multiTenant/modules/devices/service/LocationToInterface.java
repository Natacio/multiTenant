package com.nataciotecnologia.multiTenant.modules.devices.service;

import com.nataciotecnologia.multiTenant.modules.devices.Dto.PostLocationToInterfaceDto;
import com.nataciotecnologia.multiTenant.modules.devices.model.DeviceToInterface;
import com.nataciotecnologia.multiTenant.modules.devices.model.Devices;
import com.nataciotecnologia.multiTenant.modules.devices.model.InterfacesDevice;
import com.nataciotecnologia.multiTenant.modules.devices.repository.DeviceInterfaceRepository;
import com.nataciotecnologia.multiTenant.modules.devices.repository.DeviceRepository;
import com.nataciotecnologia.multiTenant.modules.devices.repository.DeviceToLocation;
import com.nataciotecnologia.multiTenant.modules.locations.model.Locations;
import com.nataciotecnologia.multiTenant.modules.locations.repository.LocationsRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationToInterface {
    private final DeviceRepository deviceRepository;
    private final DeviceInterfaceRepository deviceInterfaceRepository;
    private final LocationsRepository locationsRepository;

    private final DeviceToLocation deviceToLocation;

    public LocationToInterface(DeviceRepository deviceRepository, DeviceInterfaceRepository deviceInterfaceRepository, LocationsRepository locationsRepository, DeviceToLocation deviceToLocation) {
        this.deviceRepository = deviceRepository;
        this.deviceInterfaceRepository = deviceInterfaceRepository;
        this.locationsRepository = locationsRepository;
        this.deviceToLocation = deviceToLocation;
    }

    public void execute(PostLocationToInterfaceDto locationToInterface){
        Devices device = this.deviceRepository.findById(locationToInterface.getDevice()).orElse(null);
        InterfacesDevice inter = this.deviceInterfaceRepository.findById(locationToInterface.getInterfaceDevice()).orElse(null);
        Locations location = this.locationsRepository.findById(locationToInterface.getLocation()).orElse(null);

        if(device != null && inter !=null && location !=null){
            DeviceToInterface i = new DeviceToInterface();
            i.setLocation(location);
            i.setDeviceInterface(inter);
            i.setDevice(device);
            this.deviceToLocation.save(i);
        }else{
            throw new Error("Not found locations");
        }
    }
}
