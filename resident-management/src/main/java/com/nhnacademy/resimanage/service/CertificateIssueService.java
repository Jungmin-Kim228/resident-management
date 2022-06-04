package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.entity.CertificateIssue;
import com.nhnacademy.resimanage.entity.Resident;

public interface CertificateIssueService {
    void createCertificate(Resident resident, String typeCode);

    CertificateIssue getLast();
}
