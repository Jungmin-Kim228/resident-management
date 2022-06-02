package com.nhnacademy.resimanage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 세대전입주소 테이블
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {
    @EmbeddedId
    private Pk pk;

    // 세대와 식별관계, pk, fk
    @MapsId("householdSerialNumber")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "household_serial_number")
    @JsonBackReference
    private Household household;

    @Column(name = "house_movement_address", length = 500)
    private String houseMovementAddress;

    @Column(name = "last_address_yn", length = 1)
    private String lastAddressYn;

    @NoArgsConstructor
    @Getter
    @Setter
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "house_movement_report_date")
        private LocalDate houseMovementReportDate;

        // 세대와 식별관계, pk, fk
        @Column(name = "household_serial_number")
        private Integer householdSerialNumber;
    }

    @Builder(builderMethodName = "addHouseholdMovementAddress")
    public static HouseholdMovementAddress createHouseholdMovementAddress(LocalDate householdMovementReportDate,
                                                                          Household household,
                                                                          String houseMovementAddress,
                                                                          String lastAddressYn) {
        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress();
        householdMovementAddress.setPk(new Pk(householdMovementReportDate, household.getHouseholdSerialNumber()));
        householdMovementAddress.setHousehold(household);
        householdMovementAddress.setHouseMovementAddress(houseMovementAddress);
        householdMovementAddress.setLastAddressYn(lastAddressYn);
        return householdMovementAddress;
        // here service단에서 lastAddress optional로 기본값 처리하기
    }
}
