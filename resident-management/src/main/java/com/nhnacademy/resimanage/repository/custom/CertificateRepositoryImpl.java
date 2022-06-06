package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.domain.certificate.CertificateRecord;
import com.nhnacademy.resimanage.entity.CertificateIssue;
import com.nhnacademy.resimanage.entity.QBirthDeathReportResident;
import com.nhnacademy.resimanage.entity.QCertificateIssue;
import com.nhnacademy.resimanage.entity.QResident;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CertificateRepositoryImpl extends QuerydslRepositorySupport implements CertificateRepositoryCustom {
    public CertificateRepositoryImpl() {
        super(CertificateIssue.class);
    }

    @Override
    public BirthDeathReportCertificateTop getBirthReportTopByTargetResident(
        Integer targetResidentNum) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;

        return from(certificateIssue)
            .innerJoin(birthDeathReportResident).on(certificateIssue.resident.residentSerialNumber.eq(birthDeathReportResident.resident.residentSerialNumber))
            .where(certificateIssue.certificateTypeCode.eq("출생신고서"))
            .where(birthDeathReportResident.pk.residentSerialNumber.eq(targetResidentNum))
            .where(birthDeathReportResident.pk.birthDeathTypeCode.eq("출생"))
            .select(Projections.bean(BirthDeathReportCertificateTop.class,
                certificateIssue.certificateTypeCode,
                birthDeathReportResident.birthDeathReportDate))
            .orderBy(certificateIssue.certificateConfirmationNumber.desc())
            .fetchFirst();
    }

    @Override
    public BirthDeathReportCertificateTop getDeathReportTopByTargetResident(
        Integer targetResidentNum) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;

        return from(certificateIssue)
            .innerJoin(birthDeathReportResident).on(certificateIssue.resident.residentSerialNumber.eq(birthDeathReportResident.resident.residentSerialNumber))
            .where(certificateIssue.certificateTypeCode.eq("사망신고서"))
            .where(birthDeathReportResident.pk.residentSerialNumber.eq(targetResidentNum))
            .where(birthDeathReportResident.pk.birthDeathTypeCode.eq("사망"))
            .select(Projections.bean(BirthDeathReportCertificateTop.class,
                certificateIssue.certificateTypeCode,
                birthDeathReportResident.birthDeathReportDate))
            .orderBy(certificateIssue.certificateConfirmationNumber.desc())
            .fetchFirst();
    }

    @Override
    public List<CertificateRecord> getCertificateRecodeByResident(Integer residentNum) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;

        return from(certificateIssue)
            .where(certificateIssue.resident.residentSerialNumber.eq(residentNum))
            .select(Projections.bean(CertificateRecord.class,
                certificateIssue.certificateConfirmationNumber,
                certificateIssue.certificateTypeCode,
                certificateIssue.certificateIssueDate))
            .fetch();
    }

}
