package com.nataciotecnologia.multiTenant.modules.devices.repository;

import com.nataciotecnologia.multiTenant.modules.devices.model.DeviceToInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceToLocation extends JpaRepository<DeviceToInterface,Long> {
}
