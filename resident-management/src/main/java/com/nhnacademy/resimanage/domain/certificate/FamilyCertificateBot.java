package com.nhnacademy.resimanage.domain.certificate;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyCertificateBot {
    String familyRelationshipCode; // familyRelationship
    String name; // targetResident
    LocalDate birthDate; // targetResident
    String residentRegistrationNumber; // targetResident
    String genderCode; // targetResident
}
