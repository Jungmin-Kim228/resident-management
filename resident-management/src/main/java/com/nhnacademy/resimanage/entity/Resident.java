package com.nhnacademy.resimanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "resident")
public class Resident {
    @Id
    @Column(name = "resident_serial_number")
    private Integer residentSerialNumber;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "resident_registration_number", length = 300)
    private String residentRegistrationNumber;

    @Column(name = "gender_code", length = 20)
    private String genderCode;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "birth_place_code", length = 20)
    private String birthPlaceCode;

    @Column(name = "registration_base_address", length = 500)
    private String registrationBaseAddress;

    @Column(name = "death_date")
    private LocalDateTime deathDate;

    @Column(name = "death_place_code", length = 20)
    private String deathPlaceCode;
    
    @Column(name = "death_place_address", length = 500)
    private String deathPlaceAddress;

    // 출생사망신고주민과 식별관계
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "resident", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BirthDeathReportResident> birthDeathReportResidentList = new ArrayList<>();

    // 가족관계와 식별관계
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "baseResident", cascade = CascadeType.PERSIST)
    private List<FamilyRelationship> baseFamilyRelationshipList = new ArrayList<>();

    // 세대구성주민과 식별관계
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "resident", cascade = CascadeType.PERSIST)
    private List<HouseholdCompositionResident> householdCompositionResidentList = new ArrayList<>();

    //증명서발급과 비식별관계
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "resident", cascade = CascadeType.PERSIST)
    private List<CertificateIssue> certificateIssueList = new ArrayList<>();

    // 세대와 비식별관계
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "resident", cascade = CascadeType.PERSIST)
    private List<Household> householdList = new ArrayList<>();

    @JsonManagedReference
    @Builder(builderMethodName = "addResident")
    public static Resident createResident(Integer residentSerialNumber, String name,
                                         String residentRegistrationNumber,
                                         String genderCode, LocalDateTime birthDate,
                                         String birthPlaceCode, String registrationBaseAddress) {
        Resident resident = new Resident();
        resident.setResidentSerialNumber(residentSerialNumber);
        resident.setName(name);
        resident.setResidentRegistrationNumber(residentRegistrationNumber);
        resident.setGenderCode(genderCode);
        resident.setBirthDate(birthDate);
        resident.setBirthPlaceCode(birthPlaceCode);
        resident.setRegistrationBaseAddress(registrationBaseAddress);
        return resident;
   }
}
