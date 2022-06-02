package com.nhnacademy.resimanage.domain.household;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseholdDto {
    Integer householdSerialNumber;
    Integer householdResidentSerialNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate householdCompositionDate;
    String householdCompositionReasonCode;
    String currentHouseMovementAddress;
}
