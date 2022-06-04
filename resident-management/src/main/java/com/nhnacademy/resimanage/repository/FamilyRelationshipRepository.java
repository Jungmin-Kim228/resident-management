package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.domain.certificate.FamilyCertificateBot;
import com.nhnacademy.resimanage.entity.FamilyRelationship;
import com.nhnacademy.resimanage.repository.custom.FamilyRelationshipRepositoryCustom;
import java.util.List;
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

    @Query(value = "select F.family_relationship_code as familyRelationshipCode, TR.name, " +
        "date_format(TR.birth_date, '%Y년 %m월 %d일') as birthDate, " +
        "TR.resident_registration_number as residentRegistrationNumber, " +
        "TR.gender_code as genderCode " +
        "from family_relationship F " +
        "inner join resident TR on TR.resident_serial_number = F.family_resident_serial_number " +
        "where F.base_resident_serial_number = ?1", nativeQuery = true)
    List<FamilyCertificateBot> findFamilyCertificateBotByBaseResidentNumber(Integer baseResidentSerialNumber);
}
