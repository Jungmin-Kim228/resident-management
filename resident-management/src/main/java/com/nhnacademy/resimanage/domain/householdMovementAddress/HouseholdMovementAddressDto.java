package com.nhnacademy.resimanage.domain.householdMovementAddress;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseholdMovementAddressDto {
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate houseMovementReportDate;
    Integer householdSerialNumber;
    String houseMovementAddress;
    String lastAddressYn;
}
