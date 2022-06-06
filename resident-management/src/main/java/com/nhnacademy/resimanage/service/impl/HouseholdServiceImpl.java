package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateAddress;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateHouseholder;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateRelationship;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateTop;
import com.nhnacademy.resimanage.domain.household.HouseholdDto;
import com.nhnacademy.resimanage.domain.household.HouseholdRequest;
import com.nhnacademy.resimanage.entity.Household;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.resimanage.repository.HouseholdRepository;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.HouseholdService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    private final HouseholdRepository householdRepository;
    private final ResidentRepository residentRepository;
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;

    public HouseholdServiceImpl(HouseholdRepository householdRepository,
                                ResidentRepository residentRepository,
                                HouseholdCompositionResidentRepository householdCompositionResidentRepository) {
        this.householdRepository = householdRepository;
        this.residentRepository = residentRepository;
        this.householdCompositionResidentRepository = householdCompositionResidentRepository;
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

    @Override
    public Integer deleteHousehold(Integer householdSerialNumber) {
        Household household = householdRepository.getHouseholdByHouseholdSerialNumber(householdSerialNumber);
        householdRepository.delete(household);
        return householdSerialNumber;
    }

    @Override
    public HouseholdCertificateTop getHouseholdCertificateTop(Integer residentNum) {
        return householdRepository.getHouseholdCertificateTopByResident(residentNum);
    }

    @Override
    public HouseholdCertificateHouseholder getHouseholdCertificateHouseholder(Integer residentNum) {
        Integer householdNum = householdCompositionResidentRepository.getHouseholdSerialNumByResident(residentNum);
        return householdRepository.getHouseholdCertificateHouseholderByResident(householdNum);
    }

    @Override
    public List<HouseholdCertificateAddress> getHouseholdCertificateAddress(Integer residentNum) {
        Integer householdNum = householdCompositionResidentRepository.getHouseholdSerialNumByResident(residentNum);
        return householdRepository.getHouseholdCertificateAddressByResident(householdNum);
    }

    @Override
    public List<HouseholdCertificateRelationship> getHouseholdCertificateRelationship(
        Integer residentNum) {
        Integer householdNum = householdCompositionResidentRepository.getHouseholdSerialNumByResident(residentNum);
        return householdRepository.getHouseholdCertificateRelationshipByResident(householdNum);
    }
}
