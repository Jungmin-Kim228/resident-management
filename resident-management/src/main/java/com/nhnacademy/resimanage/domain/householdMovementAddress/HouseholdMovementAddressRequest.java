package com.nhnacademy.resimanage.domain.householdMovementAddress;

import java.time.LocalDate;
import lombok.Data;

@Data
public class HouseholdMovementAddressRequest {
    LocalDate houseMovementReportDate;
    String houseMovementAddress;
    String lastAddressYn;
}
