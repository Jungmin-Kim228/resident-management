package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateAddress;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateHouseholder;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateRelationship;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateTop;
import com.nhnacademy.resimanage.domain.household.HouseholdDto;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HouseholdRepositoryCustom {
    HouseholdDto getHouseholdDtoByHouseholdSerialNumber(Integer householdSerialNumber);

    HouseholdCertificateTop getHouseholdCertificateTopByResident(Integer residentNum);

    HouseholdCertificateHouseholder getHouseholdCertificateHouseholderByResident(Integer householdNum);

    List<HouseholdCertificateAddress> getHouseholdCertificateAddressByResident(Integer householdNum);

    List<HouseholdCertificateRelationship> getHouseholdCertificateRelationshipByResident(Integer householdNum);
}
