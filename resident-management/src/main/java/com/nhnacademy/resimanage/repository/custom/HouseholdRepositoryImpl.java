package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateAddress;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateHouseholder;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateRelationship;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateTop;
import com.nhnacademy.resimanage.domain.household.HouseholdDto;
import com.nhnacademy.resimanage.entity.Household;
import com.nhnacademy.resimanage.entity.QCertificateIssue;
import com.nhnacademy.resimanage.entity.QHousehold;
import com.nhnacademy.resimanage.entity.QHouseholdCompositionResident;
import com.nhnacademy.resimanage.entity.QHouseholdMovementAddress;
import com.nhnacademy.resimanage.entity.QResident;
import com.querydsl.core.types.Projections;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class HouseholdRepositoryImpl extends QuerydslRepositorySupport implements HouseholdRepositoryCustom {
    public HouseholdRepositoryImpl() {
        super(Household.class);
    }

    @Override
    public HouseholdDto getHouseholdDtoByHouseholdSerialNumber(Integer householdSerialNumber) {
        QHousehold household = QHousehold.household;

        return from(household)
            .where(household.householdSerialNumber.eq(householdSerialNumber))
            .select(Projections.bean(HouseholdDto.class,
                household.householdSerialNumber,
                household.resident.residentSerialNumber.as("householdResidentSerialNumber"),
                household.householdCompositionDate,
                household.householdCompositionReasonCode,
                household.currentHouseMovementAddress))
            .fetchOne();
    }

    @Override
    public HouseholdCertificateTop getHouseholdCertificateTopByResident(Integer residentNum) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;

        return from(certificateIssue)
            .where(certificateIssue.resident.residentSerialNumber.eq(residentNum))
            .where(certificateIssue.certificateTypeCode.eq("주민등록등본"))
            .select(Projections.bean(HouseholdCertificateTop.class,
                certificateIssue.certificateTypeCode,
                certificateIssue.certificateIssueDate,
                certificateIssue.certificateConfirmationNumber))
            .orderBy(certificateIssue.certificateIssueDate.desc())
            .fetchFirst();
    }

    @Override
    public HouseholdCertificateHouseholder getHouseholdCertificateHouseholderByResident(
        Integer householdNum) {
        QResident resident = QResident.resident;
        QHousehold household = QHousehold.household;

        return from(resident)
            .innerJoin(household).on(household.resident.residentSerialNumber.eq(resident.residentSerialNumber))
            .where(household.householdSerialNumber.eq(householdNum))
            .select(Projections.bean(HouseholdCertificateHouseholder.class,
                resident.name,
                household.householdCompositionReasonCode,
                household.householdCompositionDate))
            .fetchOne();
    }

    @Override
    public List<HouseholdCertificateAddress> getHouseholdCertificateAddressByResident(
        Integer householdNum) {
        QHouseholdMovementAddress householdMovementAddress = QHouseholdMovementAddress.householdMovementAddress;

        return from(householdMovementAddress)
            .where(householdMovementAddress.pk.householdSerialNumber.eq(householdNum))
            .orderBy(householdMovementAddress.pk.houseMovementReportDate.desc())
            .select(Projections.bean(HouseholdCertificateAddress.class,
                householdMovementAddress.lastAddressYn,
                householdMovementAddress.houseMovementAddress,
                householdMovementAddress.pk.houseMovementReportDate))
            .fetch();
    }

    @Override
    public List<HouseholdCertificateRelationship> getHouseholdCertificateRelationshipByResident(
        Integer householdNum) {
        QResident resident = QResident.resident;
        QHouseholdCompositionResident householdCompositionResident =
            QHouseholdCompositionResident.householdCompositionResident;

        return from(householdCompositionResident)
            .innerJoin(resident).on(householdCompositionResident.pk.residentSerialNumber.eq(resident.residentSerialNumber))
            .where(householdCompositionResident.pk.householdSerialNumber.eq(householdNum))
            .select(Projections.bean(HouseholdCertificateRelationship.class,
                householdCompositionResident.householdRelationshipCode,
                resident.name,
                resident.residentRegistrationNumber,
                householdCompositionResident.reportDate,
                householdCompositionResident.householdCompositionChangeReasonCode))
            .fetch();
    }
}
