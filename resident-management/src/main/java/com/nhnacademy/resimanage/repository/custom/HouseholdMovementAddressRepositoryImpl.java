package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressDto;
import com.nhnacademy.resimanage.entity.HouseholdMovementAddress;
import com.nhnacademy.resimanage.entity.QHouseholdMovementAddress;
import com.querydsl.core.types.Projections;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class HouseholdMovementAddressRepositoryImpl extends QuerydslRepositorySupport implements HouseholdMovementAddressRepositoryCustom {
    public HouseholdMovementAddressRepositoryImpl() {
        super(HouseholdMovementAddress.class);
    }

    @Override
    public HouseholdMovementAddressDto getHouseholdMovementAddressDtoByTwoKeys(
        LocalDate houseMovementReportDate, Integer householdSerialNumber) {
        QHouseholdMovementAddress householdMovementAddress = QHouseholdMovementAddress.householdMovementAddress;

        return from(householdMovementAddress)
            .where(householdMovementAddress.pk.houseMovementReportDate.eq(houseMovementReportDate))
            .where(householdMovementAddress.pk.householdSerialNumber.eq(householdSerialNumber))
            .select(Projections.bean(HouseholdMovementAddressDto.class,
                householdMovementAddress.pk.houseMovementReportDate,
                householdMovementAddress.pk.householdSerialNumber,
                householdMovementAddress.houseMovementAddress,
                householdMovementAddress.lastAddressYn))
            .fetchOne();
    }
}
