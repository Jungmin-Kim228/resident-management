package com.nhnacademy.resimanage.domain.deathReport;

import java.time.LocalDate;
import lombok.Data;

@Data
public class DeathReportRequest {
    Integer residentSerialNumber;
    LocalDate birthDeathReportDate;
    String deathReportQualificationsCode;
    String emailAddress;
    String phoneNumber;
}
