package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressDto;
import java.time.LocalDate;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HouseholdMovementAddressRepositoryCustom {

    HouseholdMovementAddressDto getHouseholdMovementAddressByTwoKeys(LocalDate houseMovementReportDate,
                                                                     Integer householdSerialNumber);
}
