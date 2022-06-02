package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipDto;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipRequest;
import com.nhnacademy.resimanage.entity.FamilyRelationship;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.FamilyRelationshipRepository;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.FamilyRelationshipService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;

    public FamilyRelationshipServiceImpl(FamilyRelationshipRepository familyRelationshipRepository,
                                         ResidentRepository residentRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public FamilyRelationshipDto createRelationship(Integer baseResidentSerialNumber,
                                                    FamilyRelationshipRequest request) {
        Resident baseResident = residentRepository.getResidentByResidentSerialNumber(baseResidentSerialNumber);
        FamilyRelationship familyRelationship = FamilyRelationship.addRelationship()
            .familyResidentSerialNumber(request.getFamilyResidentSerialNumber())
            .baseResident(baseResident)
            .familyRelationshipCode(request.getFamilyRelationshipCode())
            .build();

        familyRelationshipRepository.save(familyRelationship);
        residentRepository.save(baseResident);

        return familyRelationshipRepository.getFamilyRelationshipDtoByTwoSerialNumber(
            request.getFamilyResidentSerialNumber(), baseResidentSerialNumber);
    }
}
