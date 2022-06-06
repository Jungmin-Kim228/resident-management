package com.nhnacademy.resimanage.domain.certificate;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeathReportCertificateTarget {
    String name;
    String residentRegistrationNumber;
    LocalDateTime deathDate;
    String deathPlaceCode;
    String deathPlaceAddress;
}
