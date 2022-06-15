package com.nataciotecnologia.multiTenant.modules.devices.repository;

import com.nataciotecnologia.multiTenant.modules.devices.model.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Devices, UUID> {
}
