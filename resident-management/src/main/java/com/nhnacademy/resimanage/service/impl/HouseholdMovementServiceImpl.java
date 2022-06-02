package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressDto;
import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressRequest;
import com.nhnacademy.resimanage.entity.Household;
import com.nhnacademy.resimanage.entity.HouseholdMovementAddress;
import com.nhnacademy.resimanage.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.resimanage.repository.HouseholdRepository;
import com.nhnacademy.resimanage.service.HouseholdMovementAddressService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class HouseholdMovementServiceImpl implements HouseholdMovementAddressService {
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;
    private final HouseholdRepository householdRepository;

    public HouseholdMovementServiceImpl(
        HouseholdMovementAddressRepository householdMovementAddressRepository,
        HouseholdRepository householdRepository) {
        this.householdMovementAddressRepository = householdMovementAddressRepository;
        this.householdRepository = householdRepository;
    }

    @Override
    public HouseholdMovementAddressDto createHouseholdMovementAddress(Integer householdSerialNumber,
                                                                      HouseholdMovementAddressRequest request) {
        Household household = householdRepository.getHouseholdByHouseholdSerialNumber(householdSerialNumber);

        HouseholdMovementAddress householdMovementAddress = HouseholdMovementAddress.addHouseholdMovementAddress()
            .householdMovementReportDate(request.getHouseMovementReportDate())
            .household(household)
            .houseMovementAddress(request.getHouseMovementAddress())
            .lastAddressYn(Optional.ofNullable(request.getLastAddressYn()).orElse("Y"))
            .build();

        householdMovementAddressRepository.save(householdMovementAddress);
        // here familyRelationship과 같은 궁금증
        return householdMovementAddressRepository.getHouseholdMovementAddressByTwoKeys(request.getHouseMovementReportDate(),
            householdSerialNumber);
    }
}
