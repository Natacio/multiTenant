package com.nataciotecnologia.multiTenant.modules.devices.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nataciotecnologia.multiTenant.modules.locations.model.Locations;

import javax.persistence.*;

@Entity
public class DeviceToInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    @JsonBackReference
    private Devices device;

    @ManyToOne
    @JoinColumn(name = "interface_id")
    private InterfacesDevice deviceInterface;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations location;
}
