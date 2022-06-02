package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipDto;
import com.nhnacademy.resimanage.entity.FamilyRelationship;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FamilyRelationshipRepositoryCustom {
    FamilyRelationshipDto getFamilyRelationshipDtoByTwoSerialNumber(Integer familyResidentSerialNumber,
                                                                  Integer baseResidentSerialNumber);
}
