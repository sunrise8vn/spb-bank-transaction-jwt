package com.cg.model;

import com.cg.model.dto.CustomerDTO;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    @Column(precision = 12, scale = 0, updatable = false)
    private BigDecimal balance;


    @OneToOne
    @JoinColumn(name = "location_region_id", referencedColumnName = "id", nullable = false)
    private LocationRegion locationRegion;

    @OneToMany(mappedBy = "customer")
    private Set<Deposit> deposits;

    @OneToMany(mappedBy = "customer")
    private Set<Withdraw> withdraws;

    @OneToMany(mappedBy = "sender")
    private Set<Transfer> sender;

    @OneToMany(mappedBy = "recipient")
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
