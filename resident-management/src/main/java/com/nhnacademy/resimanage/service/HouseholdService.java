package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateAddress;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateHouseholder;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateRelationship;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateTop;
import com.nhnacademy.resimanage.domain.household.HouseholdDto;
import com.nhnacademy.resimanage.domain.household.HouseholdRequest;
import java.util.List;

public interface HouseholdService {
    HouseholdDto createHousehold(HouseholdRequest request);

    Integer deleteHousehold(Integer householdSerialNumber);

    HouseholdCertificateTop getHouseholdCertificateTop(Integer residentNum);

    HouseholdCertificateHouseholder getHouseholdCertificateHouseholder(Integer residentNum);

    List<HouseholdCertificateAddress> getHouseholdCertificateAddress(Integer residentNum);

    List<HouseholdCertificateRelationship> getHouseholdCertificateRelationship(Integer residentNum);
}
