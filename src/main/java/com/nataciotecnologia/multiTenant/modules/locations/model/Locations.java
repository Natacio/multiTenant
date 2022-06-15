package com.nataciotecnologia.multiTenant.modules.locations.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nataciotecnologia.multiTenant.modules.devices.model.DeviceToInterface;
import com.nataciotecnologia.multiTenant.modules.devices.model.Devices;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "location")
    @JsonManagedReference
    private List<DeviceToInterface> locationsInterfaces;

}
