package com.nataciotecnologia.multiTenant.modules.devices.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "devices")
public class Devices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false,columnDefinition = "BINARY(16)")
    private UUID id;

    private String sn;

    private String topic;

    @OneToMany(mappedBy = "device")
    @JsonManagedReference
    private List<InterfacesDevice> interfaces;
}
