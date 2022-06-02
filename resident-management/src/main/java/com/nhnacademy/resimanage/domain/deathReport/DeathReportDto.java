package com.nhnacademy.resimanage.domain.deathReport;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeathReportDto {
    String birthDeathTypeCode;
    Integer reportResidentSerialNumber;
    Integer residentSerialNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDeathReportDate;
    String deathReportQualificationsCode;
    String emailAddress;
    String phoneNumber;
}
