package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.resident.ResidentDto;
import com.nhnacademy.resimanage.domain.resident.ResidentRequest;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.ResidentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public ResidentDto createResident(ResidentRequest request) {
        Resident resident = Resident.addResident()
            .residentSerialNumber(request.getResidentSerialNumber())
            .name(request.getName())
            .residentRegistrationNumber(request.getResidentRegistrationNumber())
            .genderCode(request.getGenderCode())
            .birthDate(request.getBirthDate())
            .birthPlaceCode(request.getBirthPlaceCode())
            .registrationBaseAddress(request.getRegistrationBaseAddress())
            .build();

        residentRepository.save(resident);
        return residentRepository.getResidentDtoByResidentSerialNumber(
            resident.getResidentSerialNumber());
    }
}
