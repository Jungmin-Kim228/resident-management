package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipDto;
import com.nhnacademy.resimanage.entity.FamilyRelationship;
import com.nhnacademy.resimanage.repository.custom.FamilyRelationshipRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk>,
    FamilyRelationshipRepositoryCustom {


}
