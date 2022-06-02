package com.nhnacademy.resimanage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 세대구성주민 테이블
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {
    @EmbeddedId
    private Pk pk;

    // 세대구성주민과 식별관계 pk, fk
    @MapsId("householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    @JsonBackReference
    private Household household;

    // 주민과 식별관계, pk, fk
    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    @JsonBackReference
    private Resident resident;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "household_relationship_code", length = 20)
    private String householdRelationshipCode;

    @Column(name = "household_composition_change_reason_code", length = 20)
    private String householdCompositionChangeReasonCode;

    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    @AllArgsConstructor
    @Embeddable
    public static class Pk implements Serializable {
        // 세대구성주민과 식별관계 pk, fk
        @Column(name = "household_serial_number")
        private Integer householdSerialNumber;

        // 주민과 식별관계, pk, fk
        @Column(name = "resident_serial_number")
        private Integer residentSerialNumber;
    }
}
