package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.certificate.FamilyCertificateBot;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipDto;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FamilyRelationshipRepositoryCustom {
    FamilyRelationshipDto getFamilyRelationshipDtoByTwoSerialNumber(Integer familyResidentSerialNumber,
                                                                  Integer baseResidentSerialNumber);

}
