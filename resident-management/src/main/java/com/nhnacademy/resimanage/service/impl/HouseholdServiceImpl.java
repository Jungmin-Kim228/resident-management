package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.household.HouseholdDto;
import com.nhnacademy.resimanage.domain.household.HouseholdRequest;
import com.nhnacademy.resimanage.entity.Household;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.HouseholdRepository;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.HouseholdService;
import org.springframework.stereotype.Service;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    private final HouseholdRepository householdRepository;
    private final ResidentRepository residentRepository;

    public HouseholdServiceImpl(HouseholdRepository householdRepository,
                                ResidentRepository residentRepository) {
        this.householdRepository = householdRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public HouseholdDto createHousehold(HouseholdRequest request) {
        Resident resident = residentRepository.getResidentByResidentSerialNumber(request.getHouseholdResidentSerialNumber());

        Household household = Household.addHousehold()
            .householdSerialNumber(request.getHouseholdSerialNumber())
            .resident(resident)
            .householdCompositionDate(request.getHouseholdCompositionDate())
            .householdCompositionReasonCode(request.getHouseholdCompositionReasonCode())
            .currentHouseMovementAddress(request.getCurrentHouseMovementAddress())
            .build();

//            here#3 familyRelationship과 같은 궁금증
        householdRepository.save(household);

        return householdRepository.getHouseholdDtoByHouseholdSerialNumber(request.getHouseholdSerialNumber());
    }
}
