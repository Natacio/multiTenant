package com.nataciotecnologia.multiTenant.modules.devices.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nataciotecnologia.multiTenant.modules.locations.model.Locations;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "device_to_interface")
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
    @JsonBackReference
    private Locations location;
}
