package com.nataciotecnologia.multiTenant.controllers.locations;

import com.nataciotecnologia.multiTenant.modules.locations.model.Locations;
import com.nataciotecnologia.multiTenant.modules.locations.services.CreateLocation;
import com.nataciotecnologia.multiTenant.modules.locations.services.GetAllLocations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationsController {
    private final CreateLocation createLocation;
    private final GetAllLocations getAllLocations;

    public LocationsController(CreateLocation createLocation, GetAllLocations getAllLocations) {
        this.createLocation = createLocation;
        this.getAllLocations = getAllLocations;
    }

    @GetMapping
    public ResponseEntity<List<Locations>> index(){
        try {
            return ResponseEntity.ok().body(this.getAllLocations.execute());
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Locations> create(@RequestBody Locations locations){
        try {
            return ResponseEntity.ok().body(this.createLocation.execute(locations));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
