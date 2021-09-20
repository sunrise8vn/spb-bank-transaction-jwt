package com.cg.model.dto;

import com.cg.model.LocationRegion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LocationRegionDTO {

    Long id;

    @NotBlank(message = "The province is required")
    private String provinceId;

    @NotBlank(message = "The province is required")
    private String provinceName;

    @NotBlank(message = "The district is required")
    private String districtId;

    @NotBlank(message = "The district is required")
    private String districtName;

    @NotBlank(message = "The ward is required")
    private String wardId;

    @NotBlank(message = "The ward is required")
    private String wardName;

    @NotBlank(message = "The address is required")
    private String address;

    public LocationRegion toLocationRegion() {
        return new LocationRegion()
                .setId(id)
                .setProvinceId(provinceId)
                .setProvinceName(provinceName)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setWardId(wardId)
                .setWardName(wardName)
                .setAddress(address);
    }

}
