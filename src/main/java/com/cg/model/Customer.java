package com.cg.model;

import com.cg.model.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
@Accessors(chain = true)
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    @Digits(integer = 12, fraction = 0)
    @Column(updatable = false)
    private BigDecimal balance;


    @OneToOne
    @JoinColumn(name = "location_region_id", referencedColumnName = "id", unique = true, nullable = false)
    private LocationRegion locationRegion;


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Deposit> deposits;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Withdraw> withdraws;

    @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
    private Set<Transfer> sender;

    @OneToMany(mappedBy = "recipient", fetch = FetchType.EAGER)
    private Set<Transfer> recipient;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }

    public CustomerDTO toCustomerDTO() {
        return new CustomerDTO()
                .setId(id)
                .setFullName(fullName)
                .setEmail(email)
                .setPhone(phone)
                .setLocationRegion(locationRegion.toLocationRegionDTO())
                .setBalance(balance);
    }
}
