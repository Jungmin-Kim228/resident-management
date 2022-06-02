package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipDto;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipRequest;

public interface FamilyRelationshipService {
    FamilyRelationshipDto createRelationship(Integer baseResidentSerialNumber, FamilyRelationshipRequest request);
}
