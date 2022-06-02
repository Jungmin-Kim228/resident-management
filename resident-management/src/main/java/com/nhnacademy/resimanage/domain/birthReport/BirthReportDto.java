package com.nhnacademy.resimanage.domain.birthReport;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BirthReportDto {
    String birthDeathTypeCode;
    Integer reportResidentSerialNumber;
    Integer residentSerialNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDeathReportDate;
    String birthReportQualificationsCode;
    String emailAddress;
    String phoneNumber;
}
