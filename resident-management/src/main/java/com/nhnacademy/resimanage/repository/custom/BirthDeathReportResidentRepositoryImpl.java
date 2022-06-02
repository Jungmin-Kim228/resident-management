package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportDto;
import com.nhnacademy.resimanage.entity.BirthDeathReportResident;
import com.nhnacademy.resimanage.entity.QBirthDeathReportResident;
import com.querydsl.core.types.Projections;
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
}
