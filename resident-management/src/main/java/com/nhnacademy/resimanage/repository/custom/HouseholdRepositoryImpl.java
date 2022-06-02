package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.household.HouseholdDto;
import com.nhnacademy.resimanage.entity.Household;
import com.nhnacademy.resimanage.entity.QHousehold;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class HouseholdRepositoryImpl extends QuerydslRepositorySupport implements HouseholdRepositoryCustom {
    public HouseholdRepositoryImpl() {
        super(Household.class);
    }

    @Override
    public HouseholdDto getHouseholdDtoByHouseholdSerialNumber(Integer householdSerialNumber) {
        QHousehold household = QHousehold.household;

        return from(household)
            .where(household.householdSerialNumber.eq(householdSerialNumber))
            .select(Projections.bean(HouseholdDto.class,
                household.householdSerialNumber,
                household.resident.residentSerialNumber.as("householdResidentSerialNumber"),
                household.householdCompositionDate,
                household.householdCompositionReasonCode,
                household.currentHouseMovementAddress))
            .fetchOne();
    }
}
