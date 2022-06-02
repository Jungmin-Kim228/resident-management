package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressDto;
import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressModifyRequest;
import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressRequest;
import com.nhnacademy.resimanage.entity.Household;
import com.nhnacademy.resimanage.entity.HouseholdMovementAddress;
import com.nhnacademy.resimanage.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.resimanage.repository.HouseholdRepository;
import com.nhnacademy.resimanage.service.HouseholdMovementAddressService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public HouseholdMovementAddressDto createHouseholdMovementAddress(Integer householdSerialNumber,
                                                                      HouseholdMovementAddressRequest request) {
        Household household =
            householdRepository.getHouseholdByHouseholdSerialNumber(householdSerialNumber);

        HouseholdMovementAddress householdMovementAddress =
            HouseholdMovementAddress.addHouseholdMovementAddress()
                                    .householdMovementReportDate(
                                        request.getHouseMovementReportDate())
                                    .household(household)
                                    .houseMovementAddress(request.getHouseMovementAddress())
                                    .lastAddressYn(
                                        Optional.ofNullable(request.getLastAddressYn()).orElse("Y"))
                                    .build();

        householdMovementAddressRepository.save(householdMovementAddress);
        // here familyRelationship과 같은 궁금증
        return householdMovementAddressRepository.getHouseholdMovementAddressDtoByTwoKeys(
            request.getHouseMovementReportDate(),
            householdSerialNumber);
    }

    @Transactional
    @Override
    public HouseholdMovementAddressDto modifyHouseholdMovementAddress(Integer householdSerialNumber,
                                                                      LocalDate reportDate,
                                                                      HouseholdMovementAddressModifyRequest request) {
        HouseholdMovementAddress householdMovementAddress =
            householdMovementAddressRepository.getHouseholdMovementAddressByTwoKeys(reportDate,
                householdSerialNumber);

        householdMovementAddress.setHouseMovementAddress(request.getHouseMovementAddress());
        householdMovementAddress.setLastAddressYn(
            Optional.ofNullable(request.getLastAddressYn()).orElse("Y"));

        householdMovementAddressRepository.save(householdMovementAddress);
        return householdMovementAddressRepository.getHouseholdMovementAddressDtoByTwoKeys(
            reportDate, householdSerialNumber);
    }

    @Override
    public List<String> deleteHouseholdMovementAddress(Integer householdSerialNumber,
                                                       LocalDate reportDate) {
        HouseholdMovementAddress householdMovementAddress =
            householdMovementAddressRepository.getHouseholdMovementAddressByTwoKeys(reportDate,
                householdSerialNumber);

        householdMovementAddressRepository.delete(householdMovementAddress);
        return List.of(String.valueOf(householdSerialNumber), String.valueOf(reportDate));
    }
}
