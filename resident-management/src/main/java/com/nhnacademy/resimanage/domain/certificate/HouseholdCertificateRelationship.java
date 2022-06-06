package com.nhnacademy.resimanage.domain.certificate;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseholdCertificateRelationship {
    String householdRelationshipCode;
    String name;
    String residentRegistrationNumber;
    LocalDate reportDate;
    String householdCompositionChangeReasonCode;
}
