package com.nhnacademy.resimanage.domain.certificate;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BirthReportCertificateTarget {
    String name;
    String genderCode;
    LocalDateTime birthDate;
    String birthPlaceCode;
    String registrationBaseAddress;
}
