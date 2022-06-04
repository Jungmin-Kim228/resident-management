package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.entity.CertificateIssue;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.CertificateRepository;
import com.nhnacademy.resimanage.service.CertificateIssueService;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateIssueService {
    private long familyRelationshipNumber = 1234567800000000L;
    private long householdNumber = 9876543200000000L;

    private final CertificateRepository certificateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public void createCertificate(Resident resident, String typeCode) {
        CertificateIssue certificateIssue;
        Long confirmationNumber;
        if (typeCode.equals("가족관계증명서")) {
            confirmationNumber = certificateRepository.getCount();
            certificateIssue = CertificateIssue.addCertificateIssue()
                .resident(resident)
                .certificateTypeCode(typeCode)
                .certificateConfirmationNumber(familyRelationshipNumber+confirmationNumber)
                .build();
        } else { // 본 프로그램에서는 가족관계증명서와 주민등록등본만 있음
            confirmationNumber = certificateRepository.getCount();
            certificateIssue = CertificateIssue.addCertificateIssue()
                .resident(resident)
                .certificateTypeCode(typeCode)
                .certificateConfirmationNumber(householdNumber+confirmationNumber)
                .build();
        }
        certificateRepository.save(certificateIssue);
    }

    @Override
    public CertificateIssue getLast() {
        return certificateRepository.getLastBy();
    }
}
