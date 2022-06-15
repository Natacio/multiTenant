package com.nataciotecnologia.multiTenant.modules.locations.repository;

import com.nataciotecnologia.multiTenant.modules.locations.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends JpaRepository<Locations,Long> {
}
