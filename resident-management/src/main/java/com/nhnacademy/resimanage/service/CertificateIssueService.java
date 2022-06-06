package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.domain.certificate.CertificateRecord;
import com.nhnacademy.resimanage.entity.CertificateIssue;
import java.util.List;

public interface CertificateIssueService {
    void createCertificate(Integer residentNum, String typeCode);

    CertificateIssue getLast();

    BirthDeathReportCertificateTop getBirthReportTop(Integer targetResidentNum);

    BirthDeathReportCertificateTop getDeathReportTop(Integer targetResidentNum);

    List<CertificateRecord> getCertificateRecord(Integer residentNum);
}
