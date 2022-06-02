package com.nhnacademy.resimanage.domain.birthReport;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BirthReportModifyRequest {
    LocalDate birthDeathReportDate;
    String birthReportQualificationsCode;
    String emailAddress;
    String phoneNumber;
}
