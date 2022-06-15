package com.nataciotecnologia.multiTenant.modules.devices.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "interfaces")
public class InterfacesDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(nullable = false,unique = true)
    private String topic;

    @ManyToOne
    @JoinColumn(name = "device_id")
    @JsonBackReference
    private Devices device;
}
