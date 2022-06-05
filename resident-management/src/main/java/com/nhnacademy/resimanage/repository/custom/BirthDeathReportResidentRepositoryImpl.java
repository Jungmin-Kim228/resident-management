package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateParent;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateTarget;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportDto;
import com.nhnacademy.resimanage.entity.BirthDeathReportResident;
import com.nhnacademy.resimanage.entity.QBirthDeathReportResident;
import com.nhnacademy.resimanage.entity.QFamilyRelationship;
import com.nhnacademy.resimanage.entity.QResident;
import com.nhnacademy.resimanage.entity.Resident;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BirthDeathReportResidentRepositoryImpl extends QuerydslRepositorySupport
    implements BirthDeathReportResidentRepositoryCustom {
    public BirthDeathReportResidentRepositoryImpl() {
        super(BirthDeathReportResident.class);
    }

    @Override
    public BirthReportDto getBirthReportDtoBySerialNumbers(Integer reportSerialNumber,
                                                           Integer targetSerialNumber) {

        QBirthDeathReportResident birthDeathReportResident =
            QBirthDeathReportResident.birthDeathReportResident;

        return from(birthDeathReportResident)
            .where(birthDeathReportResident.pk.birthDeathTypeCode.eq("출생"))
            .where(birthDeathReportResident.pk.reportResidentSerialNumber.eq(reportSerialNumber))
            .where(birthDeathReportResident.pk.residentSerialNumber.eq(targetSerialNumber))
            .select(Projections.bean(BirthReportDto.class,
                birthDeathReportResident.pk.birthDeathTypeCode,
                birthDeathReportResident.pk.reportResidentSerialNumber,
                birthDeathReportResident.pk.residentSerialNumber,
                birthDeathReportResident.birthDeathReportDate,
                birthDeathReportResident.birthReportQualificationsCode,
                birthDeathReportResident.emailAddress,
                birthDeathReportResident.phoneNumber))
            .fetchOne();
    }

    @Override
    public DeathReportDto getDeathReportDtoBySerialNumbers(Integer reportSerialNumber,
                                                           Integer targetSerialNumber) {

        QBirthDeathReportResident birthDeathReportResident =
            QBirthDeathReportResident.birthDeathReportResident;

        return from(birthDeathReportResident)
            .where(birthDeathReportResident.pk.birthDeathTypeCode.eq("사망"))
            .where(birthDeathReportResident.pk.reportResidentSerialNumber.eq(reportSerialNumber))
            .where(birthDeathReportResident.pk.residentSerialNumber.eq(targetSerialNumber))
            .select(Projections.bean(DeathReportDto.class,
                birthDeathReportResident.pk.birthDeathTypeCode,
                birthDeathReportResident.pk.reportResidentSerialNumber,
                birthDeathReportResident.pk.residentSerialNumber,
                birthDeathReportResident.birthDeathReportDate,
                birthDeathReportResident.deathReportQualificationsCode,
                birthDeathReportResident.emailAddress,
                birthDeathReportResident.phoneNumber))
            .fetchOne();
    }

    @Override
    public BirthReportCertificateTarget getBirthReportTargetByTargetResident(
        Resident targetResident) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        QResident resident = QResident.resident;

        // here innerjoin(birthDeathReportResident.resident, resident)가 안됌...왜?
        return from(resident)
            .innerJoin(birthDeathReportResident).on(birthDeathReportResident.pk.residentSerialNumber.eq(resident.residentSerialNumber))
            .where(birthDeathReportResident.pk.birthDeathTypeCode.eq("출생"))
            .where(birthDeathReportResident.pk.residentSerialNumber.eq(targetResident.getResidentSerialNumber()))
            .select(Projections.bean(BirthReportCertificateTarget.class,
                resident.name,
                resident.genderCode,
                resident.birthDate,
                resident.birthPlaceCode,
                resident.registrationBaseAddress
                ))
            .fetchOne();
    }

    @Override
    public List<BirthReportCertificateParent> getBirthReportParentByTargetResident(
        Resident targetResident) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;
        QResident resident =QResident.resident;

        return from(familyRelationship)
            .innerJoin(resident).on(resident.residentSerialNumber.eq(familyRelationship.pk.familyResidentSerialNumber))
            .where(familyRelationship.pk.baseResidentSerialNumber.eq(targetResident.getResidentSerialNumber()))
            .select(Projections.bean(BirthReportCertificateParent.class,
                resident.name,
                resident.residentRegistrationNumber))
            .fetch();

    }
}