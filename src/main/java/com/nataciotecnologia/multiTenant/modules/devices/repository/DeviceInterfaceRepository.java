package com.nataciotecnologia.multiTenant.modules.devices.repository;

import com.nataciotecnologia.multiTenant.modules.devices.model.InterfacesDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceInterfaceRepository extends JpaRepository<InterfacesDevice,Long> {
}
