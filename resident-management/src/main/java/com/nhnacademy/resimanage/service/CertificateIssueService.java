package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.entity.CertificateIssue;

public interface CertificateIssueService {
    void createCertificate(Integer residentNum, String typeCode);

    CertificateIssue getLast();

    BirthDeathReportCertificateTop getBirthReportTop(Integer targetResidentNum);

    BirthDeathReportCertificateTop getDeathReportTop(Integer targetResidentNum);
}
