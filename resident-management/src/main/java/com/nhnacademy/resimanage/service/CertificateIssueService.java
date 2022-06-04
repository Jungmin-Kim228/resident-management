package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.entity.Resident;
import java.time.LocalDate;

public interface CertificateIssueService {
    void createCertificate(Resident resident, String typeCode);
}
