package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.entity.FamilyRelationship;
import com.nhnacademy.resimanage.repository.custom.FamilyRelationshipRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRelationshipRepository
    extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk>,
    FamilyRelationshipRepositoryCustom {

    @Query("select i from FamilyRelationship i where i.pk.familyResidentSerialNumber = ?1 and i.pk.baseResidentSerialNumber = ?2")
    FamilyRelationship getFamilyRelationshipByTwoSerialNumber(Integer familyResidentSerialNumber,
                                                              Integer baseResidentSerialNumber);
}
