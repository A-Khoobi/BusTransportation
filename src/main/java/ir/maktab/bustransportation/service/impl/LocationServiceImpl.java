package ir.maktab.bustransportation.service.impl;

import ir.maktab.bustransportation.domain.Location;
import ir.maktab.bustransportation.repository.LocationRepository;
import ir.maktab.bustransportation.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
