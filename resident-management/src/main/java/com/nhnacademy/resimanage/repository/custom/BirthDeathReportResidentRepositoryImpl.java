package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateParent;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateReporter;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateTarget;
import com.nhnacademy.resimanage.domain.certificate.DeathReportCertificateReporter;
import com.nhnacademy.resimanage.domain.certificate.DeathReportCertificateTarget;
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
        Integer targetResidentNum) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        QResident resident = QResident.resident;

        // here innerjoin(birthDeathReportResident.resident, resident)가 안됌...왜?
        return from(resident)
            .innerJoin(birthDeathReportResident).on(birthDeathReportResident.pk.residentSerialNumber.eq(resident.residentSerialNumber))
            .where(birthDeathReportResident.pk.birthDeathTypeCode.eq("출생"))
            .where(birthDeathReportResident.pk.residentSerialNumber.eq(targetResidentNum))
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
        Integer targetResidentNum) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;
        QResident resident =QResident.resident;

        return from(familyRelationship)
            .innerJoin(resident).on(resident.residentSerialNumber.eq(familyRelationship.pk.familyResidentSerialNumber))
            .where(familyRelationship.pk.baseResidentSerialNumber.eq(targetResidentNum))
            .select(Projections.bean(BirthReportCertificateParent.class,
                familyRelationship.familyRelationshipCode,
                resident.name,
                resident.residentRegistrationNumber))
            .fetch();
    }

    @Override
    public BirthReportCertificateReporter getBirthReportReporterByTargetResident(
        Integer targetResidentNum) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        QResident resident = QResident.resident;

        return from(resident)
            .innerJoin(birthDeathReportResident).on(resident.residentSerialNumber.eq(birthDeathReportResident.pk.reportResidentSerialNumber))
            .where(birthDeathReportResident.pk.residentSerialNumber.eq(targetResidentNum))
            .where(birthDeathReportResident.pk.birthDeathTypeCode.eq("출생"))
            .select(Projections.bean(BirthReportCertificateReporter.class,
                resident.name,
                resident.residentRegistrationNumber,
                birthDeathReportResident.birthReportQualificationsCode,
                birthDeathReportResident.emailAddress,
                birthDeathReportResident.phoneNumber))
            .fetchOne();
    }

    @Override
    public DeathReportCertificateTarget getDeathReportTargetByTargetResident(
        Integer targetResidentNum) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        QResident resident = QResident.resident;

        return from(resident)
            .leftJoin(birthDeathReportResident).on(resident.residentSerialNumber.eq(birthDeathReportResident.pk.residentSerialNumber))
            .where(birthDeathReportResident.pk.birthDeathTypeCode.eq("사망"))
            .where(resident.residentSerialNumber.eq(targetResidentNum))
            .select(Projections.bean(DeathReportCertificateTarget.class,
                resident.name,
                resident.residentRegistrationNumber,
                resident.deathDate,
                resident.deathPlaceCode,
                resident.deathPlaceAddress))
            .fetchOne();
    }

    @Override
    public DeathReportCertificateReporter getDeathReportReporterByTargetResident(
        Integer targetResidentNum) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        QResident resident = QResident.resident;

        return from(resident)
            .innerJoin(birthDeathReportResident).on(birthDeathReportResident.pk.reportResidentSerialNumber.eq(resident.residentSerialNumber))
            .where(birthDeathReportResident.pk.birthDeathTypeCode.eq("사망"))
            .where(birthDeathReportResident.pk.residentSerialNumber.eq(targetResidentNum))
            .select(Projections.bean(DeathReportCertificateReporter.class,
                resident.name,
                resident.residentRegistrationNumber,
                birthDeathReportResident.deathReportQualificationsCode,
                birthDeathReportResident.emailAddress,
                birthDeathReportResident.phoneNumber))
            .fetchOne();
    }
}
