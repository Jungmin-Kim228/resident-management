package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.entity.CertificateIssue;
import com.nhnacademy.resimanage.entity.QBirthDeathReportResident;
import com.nhnacademy.resimanage.entity.QCertificateIssue;
import com.nhnacademy.resimanage.entity.Resident;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CertificateRepositoryImpl extends QuerydslRepositorySupport implements CertificateRepositoryCustom {
    public CertificateRepositoryImpl() {
        super(CertificateIssue.class);
    }

    @Override
    public BirthDeathReportCertificateTop getBirthReportTopByTargetResident(
        Resident targetResident) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;

        return from(certificateIssue)
            .innerJoin(birthDeathReportResident).on(certificateIssue.resident.residentSerialNumber.eq(birthDeathReportResident.resident.residentSerialNumber))
            .where(certificateIssue.certificateTypeCode.eq("출생신고서"))
            .where(birthDeathReportResident.pk.residentSerialNumber.eq(targetResident.getResidentSerialNumber()))
            .select(Projections.bean(BirthDeathReportCertificateTop.class,
                certificateIssue.certificateTypeCode,
                birthDeathReportResident.birthDeathReportDate))
            .orderBy(certificateIssue.certificateConfirmationNumber.desc())
            .fetchFirst();
    }
}
