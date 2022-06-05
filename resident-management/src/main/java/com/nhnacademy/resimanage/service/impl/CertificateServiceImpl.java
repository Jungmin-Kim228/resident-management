package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.entity.CertificateIssue;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.CertificateRepository;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.CertificateIssueService;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateIssueService {
    private long familyRelationshipNumber = 1234567800000000L;
    private long householdNumber = 9876543200000000L;
    private long birthReportNumber = 1111111100000000L;
    private long deathReportNumber = 9999999900000000L;

    private final CertificateRepository certificateRepository;
    private final ResidentRepository residentRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository,
                                  ResidentRepository residentRepository) {
        this.certificateRepository = certificateRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public void createCertificate(Integer residentNum, String typeCode) {
        Resident resident = residentRepository.getResidentByResidentSerialNumber(residentNum);
        Long confirmationNumber = certificateRepository.getCount();
        CertificateIssue certificateIssue;

        if (typeCode.equals("가족관계증명서")) {
            certificateIssue = CertificateIssue.addCertificateIssue()
                .resident(resident)
                .certificateTypeCode(typeCode)
                .certificateConfirmationNumber(familyRelationshipNumber+confirmationNumber)
                .build();
        } else if (typeCode.equals("주민등록등본")) {
            certificateIssue = CertificateIssue.addCertificateIssue()
                .resident(resident)
                .certificateTypeCode(typeCode)
                .certificateConfirmationNumber(householdNumber+confirmationNumber)
                .build();
        } else if (typeCode.equals("출생신고서")) {
            certificateIssue = CertificateIssue.addCertificateIssue()
                                               .resident(resident)
                                               .certificateTypeCode(typeCode)
                                               .certificateConfirmationNumber(birthReportNumber+confirmationNumber)
                                               .build();
        } else { // 사망신고서
            certificateIssue = CertificateIssue.addCertificateIssue()
                                               .resident(resident)
                                               .certificateTypeCode(typeCode)
                                               .certificateConfirmationNumber(deathReportNumber+confirmationNumber)
                                               .build();
        }
        certificateRepository.save(certificateIssue);
    }

    @Override
    public CertificateIssue getLast() {
        return certificateRepository.getLastBy();
    }

    @Override
    public BirthDeathReportCertificateTop getBirthReportTop(Integer targetResidentNum) {
        return certificateRepository.getBirthReportTopByTargetResident(targetResidentNum);
    }

    @Override
    public BirthDeathReportCertificateTop getDeathReportTop(Integer targetResidentNum) {
        return certificateRepository.getDeathReportTopByTargetResident(targetResidentNum);
    }
}
