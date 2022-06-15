package com.nataciotecnologia.multiTenant.modules.locations.services;

import com.nataciotecnologia.multiTenant.modules.locations.model.Locations;
import com.nataciotecnologia.multiTenant.modules.locations.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateLocation {
    @Autowired
    LocationsRepository locationsRepository;
    public Locations execute(Locations location){
        return locationsRepository.save(location);
    }
}
