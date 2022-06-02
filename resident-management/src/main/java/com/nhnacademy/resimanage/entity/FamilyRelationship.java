package com.nhnacademy.resimanage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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

// 가족관계 테이블
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {
    @EmbeddedId
    private Pk pk;

    // 주민과 식별관계, pk, fk, 복합키, 기준 주민
    @MapsId("baseResidentSerialNumber")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "base_resident_serial_number")
    @JsonBackReference
    private Resident baseResident;

    @Column(name = "family_relationship_code", length = 20)
    private String familyRelationshipCode;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "family_resident_serial_number")
        private Integer familyResidentSerialNumber;

        // 주민과 식별관계, pk, fk, 복합키
        @Column(name = "base_resident_serial_number")
        private Integer baseResidentSerialNumber;
    }

    @Builder(builderMethodName = "addRelationship")
    public static FamilyRelationship createFamilyRelationship(Integer familyResidentSerialNumber,
                                                              Resident baseResident,
                                                              String familyRelationshipCode) {
        FamilyRelationship relationship = new FamilyRelationship();
        relationship.setPk(new Pk(familyResidentSerialNumber, baseResident.getResidentSerialNumber()));
        relationship.setBaseResident(baseResident);
        relationship.setFamilyRelationshipCode(familyRelationshipCode);
        return relationship;
    }
}
