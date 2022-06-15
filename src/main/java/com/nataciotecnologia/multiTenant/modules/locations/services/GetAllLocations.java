package com.nataciotecnologia.multiTenant.modules.locations.services;

import com.nataciotecnologia.multiTenant.modules.locations.model.Locations;
import com.nataciotecnologia.multiTenant.modules.locations.repository.LocationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllLocations {
    private final LocationsRepository locationsRepository;

    public GetAllLocations(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public List<Locations> execute(){
        return this.locationsRepository.findAll();
    }
}
