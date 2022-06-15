package com.nataciotecnologia.multiTenant.modules.devices.controller;

import com.nataciotecnologia.multiTenant.modules.devices.Dto.PostInterfaceDto;
import com.nataciotecnologia.multiTenant.modules.devices.Dto.PostLocationToInterfaceDto;
import com.nataciotecnologia.multiTenant.modules.devices.model.Devices;
import com.nataciotecnologia.multiTenant.modules.devices.model.InterfacesDevice;
import com.nataciotecnologia.multiTenant.modules.devices.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("devices")
public class ControllerDevices {
    private final CreateDevice createDevice;
    private final FindAllDevices findAllDevices;
    private final CreateInterface createInterface;
    private final FindAllInterfaces findAllInterfaces;

    private final LocationToInterface locationToInterface;

    public ControllerDevices(CreateDevice createDevice, FindAllDevices findAllDevices, CreateInterface createInterface, FindAllInterfaces findAllInterfaces, LocationToInterface locationToInterface) {
        this.createDevice = createDevice;
        this.findAllDevices = findAllDevices;
        this.createInterface = createInterface;
        this.findAllInterfaces = findAllInterfaces;
        this.locationToInterface = locationToInterface;
    }

    @GetMapping
    public ResponseEntity<List<Devices>> getAllDevices(){

        try {
            return ResponseEntity.ok().body(findAllDevices.execute());
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Devices> createDevice(@RequestBody Devices device){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(createDevice.execute(device));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/interface")
    public ResponseEntity<InterfacesDevice> createInterface(@RequestBody PostInterfaceDto interfaceDevice){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(createInterface.execute(interfaceDevice));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/location")
    public ResponseEntity<Void> createLocationsInterface(@RequestBody PostLocationToInterfaceDto postLocationToInterfaceDto){

        try {
            this.locationToInterface.execute(postLocationToInterfaceDto);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
