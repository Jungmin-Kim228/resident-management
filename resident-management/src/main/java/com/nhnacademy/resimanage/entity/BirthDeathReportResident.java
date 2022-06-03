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

// 출생사망신고주민 테이블
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "birth_death_report_resident")
public class BirthDeathReportResident {
    @EmbeddedId
    private Pk pk;

    // 주민과 식별관계 pk, fk, 복합키
    @MapsId("residentSerialNumber")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "resident_serial_number")
    @JsonBackReference
    private Resident resident;

    @Column(name = "birth_death_report_date")
    private LocalDate birthDeathReportDate;

    @Column(name = "birth_report_qualifications_code", length = 20)
    private String birthReportQualificationsCode;

    @Column(name = "death_report_qualifications_code", length = 20)
    private String deathReportQualificationsCode;

    @Column(name = "email_address", length = 50)
    private String emailAddress;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "birth_death_type_code", length = 2)
        private String birthDeathTypeCode;

        @Column(name = "report_resident_serial_number")
        private Integer reportResidentSerialNumber;

        // 주민과 식별관계 pk, fk, 복합키
        @Column(name = "resident_serial_number")
        private Integer residentSerialNumber;
    }

    @Builder(builderMethodName = "addBirthDeathReportResident")
    public static BirthDeathReportResident createBirthReportResident(
        String birthDeathTypecode,
        Integer reportResidentSerialNumber,
        Resident resident,
        LocalDate birthDeathReportDate,
        String birthReportQualificationsCode,
        String deathReportQualificationsCode,
        String emailAddress,
        String phoneNumber) {
        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
        birthDeathReportResident.setPk(new Pk(birthDeathTypecode, reportResidentSerialNumber, resident.getResidentSerialNumber()));
        birthDeathReportResident.setResident(resident);
        birthDeathReportResident.setBirthDeathReportDate(birthDeathReportDate);
        birthDeathReportResident.setBirthReportQualificationsCode(birthReportQualificationsCode);
        birthDeathReportResident.setDeathReportQualificationsCode(deathReportQualificationsCode);
        birthDeathReportResident.setEmailAddress(emailAddress);
        birthDeathReportResident.setPhoneNumber(phoneNumber);
        return birthDeathReportResident;
    }
}
