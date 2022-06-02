package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipDto;
import com.nhnacademy.resimanage.entity.FamilyRelationship;
import com.nhnacademy.resimanage.entity.QFamilyRelationship;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport
    implements FamilyRelationshipRepositoryCustom {

    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public FamilyRelationshipDto getFamilyRelationshipDtoByTwoSerialNumber(
        Integer familyResidentSerialNumber, Integer baseResidentSerialNumber) {

        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        return from(familyRelationship)
            .where(familyRelationship.pk.familyResidentSerialNumber.eq(familyResidentSerialNumber))
            .where(familyRelationship.pk.baseResidentSerialNumber.eq(baseResidentSerialNumber))
            .select(Projections.bean(FamilyRelationshipDto.class,
                familyRelationship.pk.familyResidentSerialNumber,
                familyRelationship.pk.baseResidentSerialNumber,
                familyRelationship.familyRelationshipCode))
            .fetchOne();
    }
}
