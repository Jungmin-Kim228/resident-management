package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressDto;
import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressModifyRequest;
import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressRequest;
import java.time.LocalDate;
import java.util.List;

public interface HouseholdMovementAddressService {

    HouseholdMovementAddressDto createHouseholdMovementAddress(Integer householdSerialNumber, HouseholdMovementAddressRequest request);

    HouseholdMovementAddressDto modifyHouseholdMovementAddress(Integer householdSerialNumber, LocalDate reportDate, HouseholdMovementAddressModifyRequest request);

    List<String> deleteHouseholdMovementAddress(Integer householdSerialNumber, LocalDate reportDate);
}
