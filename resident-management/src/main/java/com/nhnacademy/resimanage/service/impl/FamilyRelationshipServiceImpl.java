package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipDto;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipModifyRequest;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipRequest;
import com.nhnacademy.resimanage.entity.FamilyRelationship;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.FamilyRelationshipRepository;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.FamilyRelationshipService;
import java.util.List;
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

        Resident baseResident =
            residentRepository.getResidentByResidentSerialNumber(baseResidentSerialNumber);

        FamilyRelationship familyRelationship = FamilyRelationship.addRelationship()
                                                                  .familyResidentSerialNumber(
                                                                      request.getFamilyResidentSerialNumber())
                                                                  .baseResident(baseResident)
                                                                  .familyRelationshipCode(
                                                                      request.getFamilyRelationshipCode())
                                                                  .build();

        familyRelationshipRepository.save(familyRelationship);
//        residentRepository.save(baseResident);
//        here#1 resident에는 persist, familyRelationship에는 persist, merge
//        here#1 이걸 안해도 resident에 자동으로 familyRelationshipList가 추가될까??

        return familyRelationshipRepository.getFamilyRelationshipDtoByTwoSerialNumber(
            request.getFamilyResidentSerialNumber(), baseResidentSerialNumber);
    }

    @Transactional
    @Override
    public FamilyRelationshipDto modifyRelationship(Integer baseResidentSerialNumber,
                                                    Integer familyResidentSerialNumber,
                                                    FamilyRelationshipModifyRequest request) {

        FamilyRelationship familyRelationship =
            familyRelationshipRepository.getFamilyRelationshipByTwoSerialNumber(
                familyResidentSerialNumber, baseResidentSerialNumber);

        familyRelationship.setFamilyRelationshipCode(request.getFamilyRelationshipCode());
        familyRelationshipRepository.save(familyRelationship);
        return familyRelationshipRepository.getFamilyRelationshipDtoByTwoSerialNumber(
            familyResidentSerialNumber,
            baseResidentSerialNumber);
    }

    @Transactional
    @Override
    public List<Integer> deleteRelationship(Integer baseResidentSerialNumber,
                                            Integer familyResidentSerialNumber) {
        FamilyRelationship familyRelationship =
            familyRelationshipRepository.getFamilyRelationshipByTwoSerialNumber(
                familyResidentSerialNumber, baseResidentSerialNumber);

        familyRelationshipRepository.delete(familyRelationship);

        return List.of(familyResidentSerialNumber, baseResidentSerialNumber);
    }
}
