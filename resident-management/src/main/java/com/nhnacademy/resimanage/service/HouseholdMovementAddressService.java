package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressDto;
import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressRequest;

public interface HouseholdMovementAddressService {

    HouseholdMovementAddressDto createHouseholdMovementAddress(Integer householdSerialNumber, HouseholdMovementAddressRequest request);
}
