package com.nhnacademy.resimanage.domain.certificate;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseholdCertificateAddress {
    String lastAddressYn;
    String houseMovementAddress;
    LocalDate houseMovementReportDate;
}
