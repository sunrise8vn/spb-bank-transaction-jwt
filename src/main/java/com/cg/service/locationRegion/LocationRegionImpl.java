package com.cg.service.locationRegion;

import com.cg.model.LocationRegion;
import com.cg.model.dto.LocationRegionDTO;
import com.cg.repository.LocationRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationRegionImpl implements ILocationRegionService {

    @Autowired
    private LocationRegionRepository locationRegionRepository;

    @Override
    public List<LocationRegion> findAll() {
        return null;
    }

    @Override
    public Optional<LocationRegion> findById(Long id) {
        return locationRegionRepository.findById(id);
    }

    @Override
    public LocationRegion getById(Long id) {
        return locationRegionRepository.getById(id);
    }

    @Override
    public LocationRegionDTO getLocationRegionDTOById(Long id) {
        return locationRegionRepository.getLocationRegionDTOById(id);
    }

    @Override
    public LocationRegion save(LocationRegion locationRegion) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
