package com.nhnacademy.resimanage.domain.household;

import java.time.LocalDate;
import lombok.Data;

@Data
public class HouseholdRequest {
    Integer householdSerialNumber;
    Integer householdResidentSerialNumber;
    LocalDate householdCompositionDate;
    String householdCompositionReasonCode;
    String currentHouseMovementAddress;
}
