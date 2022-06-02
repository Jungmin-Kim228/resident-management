package com.nhnacademy.resimanage.domain.birthReport;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BirthReportRequest {
    Integer residentSerialNumber;
    LocalDate birthDeathReportDate;
    String birthReportQualificationsCode;
    String emailAddress;
    String phoneNumber;
}
