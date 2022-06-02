package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.household.HouseholdDto;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HouseholdRepositoryCustom {
    HouseholdDto getHouseholdDtoByHouseholdSerialNumber(Integer householdSerialNumber);
}
