package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.household.HouseholdDto;
import com.nhnacademy.resimanage.domain.household.HouseholdRequest;

public interface HouseholdService {
    HouseholdDto createHousehold(HouseholdRequest request);
}
