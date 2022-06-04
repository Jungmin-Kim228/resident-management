package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.resident.ResidentDto;
import com.nhnacademy.resimanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.resimanage.domain.resident.ResidentRequest;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.ResidentService;
import java.util.List;
import java.util.Optional;
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

    @Transactional
    @Override
    public ResidentDto modifyResident(Integer residentSerialNumber, ResidentModifyRequest request) {
        Resident resident = residentRepository.getResidentByResidentSerialNumber(residentSerialNumber);
        resident.setName(Optional.ofNullable(request.getName()).orElse(resident.getName()));
        resident.setResidentRegistrationNumber(Optional.ofNullable(request.getResidentRegistrationNumber()).orElse(resident.getResidentRegistrationNumber()));
        resident.setGenderCode(Optional.ofNullable(request.getGenderCode()).orElse(resident.getGenderCode()));
        resident.setBirthDate(Optional.ofNullable(request.getBirthDate()).orElse(resident.getBirthDate()));
        resident.setBirthPlaceCode(Optional.ofNullable(request.getBirthPlaceCode()).orElse(resident.getBirthPlaceCode()));
        resident.setRegistrationBaseAddress(Optional.ofNullable(request.getRegistrationBaseAddress()).orElse(resident.getRegistrationBaseAddress()));
        resident.setDeathDate(Optional.ofNullable(request.getDeathDate()).orElse(resident.getDeathDate()));
        resident.setDeathPlaceCode(Optional.ofNullable(request.getDeathPlaceCode()).orElse(resident.getDeathPlaceCode()));
        resident.setDeathPlaceAddress(Optional.ofNullable(request.getDeathPlaceAddress()).orElse(resident.getDeathPlaceAddress()));

        residentRepository.save(resident);
        return residentRepository.getResidentDtoByResidentSerialNumber(residentSerialNumber);
    }

    @Override
    public List<Resident> getAllResidents() {
        return residentRepository.getAllBy();
    }

    @Override
    public Resident getResidentBySerialNum(Integer residentSerialNumber) {
        return residentRepository.getResidentByResidentSerialNumber(residentSerialNumber);
    }
}
