package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.domain.certificate.CertificateRecord;
import com.nhnacademy.resimanage.entity.CertificateIssue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CertificateIssueService {
    void createCertificate(Integer residentNum, String typeCode);

    CertificateIssue getLast();

    BirthDeathReportCertificateTop getBirthReportTop(Integer targetResidentNum);

    BirthDeathReportCertificateTop getDeathReportTop(Integer targetResidentNum);

    Page<CertificateRecord> getCertificateRecords(Pageable pageable, Integer residentNum);
}
