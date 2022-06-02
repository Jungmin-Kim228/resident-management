package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipDto;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipModifyRequest;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipRequest;
import java.util.List;

public interface FamilyRelationshipService {
    FamilyRelationshipDto createRelationship(Integer baseResidentSerialNumber, FamilyRelationshipRequest request);

    FamilyRelationshipDto modifyRelationship(Integer baseResidentSerialNumber, Integer familyResidentSerialNumber, FamilyRelationshipModifyRequest request);

    List<Integer> deleteRelationship(Integer baseResidentSerialNumber, Integer familyResidentSerialNumber);
}
