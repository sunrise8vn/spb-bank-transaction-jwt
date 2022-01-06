package com.cg.repository;

import com.cg.model.LocationRegion;
import com.cg.model.dto.LocationRegionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRegionRepository extends JpaRepository<LocationRegion, Long> {

    @Query("SELECT NEW com.cg.model.dto.LocationRegionDTO (" +
                "lr.id, " +
                "lr.provinceId, " +
                "lr.provinceName, " +
                "lr.districtId, " +
                "lr.districtName, " +
                "lr.wardId, " +
                "lr.wardName, " +
                "lr.address" +
            ") " +
            "FROM LocationRegion lr " +
            "WHERE lr.id = ?1 "
    )
    LocationRegionDTO getLocationRegionDTOById(Long id);

}
