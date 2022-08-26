package com.cg.model.dto;

import com.cg.model.Customer;
import com.cg.model.LocationRegion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private long id;

    @NotBlank(message = "The full name is required")
    private String fullName;

    @NotBlank(message = "The email is required")
    @Email(message = "The email address is invalid")
    @Size(min = 5, max = 50, message = "The length of email must be between 5 and 50 characters")
    private String email;

    private String phone;

    @Valid
    private LocationRegionDTO locationRegion;

    private BigDecimal balance;

    public CustomerDTO(long id, String fullName, String email, String phone, LocationRegion locationRegion, BigDecimal balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion.toLocationRegionDTO();
        this.balance = balance;
    }


    public Customer toCustomer() {
        return Customer.builder()
                .id(id)
                .fullName(fullName)
                .email(email)
                .phone(phone)
                .locationRegion(locationRegion.toLocationRegion())
                .balance(balance)
                .build();
    }
}
