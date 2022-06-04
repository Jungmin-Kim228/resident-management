package com.nhnacademy.resimanage.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 증명서발급 테이블
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "certificate_issue")
public class CertificateIssue {
    @Id
    @Column(name = "certificate_confirmation_number")
    private Long certificateConfirmationNumber;

    // 주민과 비식별관계, fk
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "certificate_type_code", length = 20)
    private String certificateTypeCode;

    @Column(name = "certificate_issue_date")
    private LocalDate certificateIssueDate;

    @Builder(builderMethodName = "addCertificateIssue")
    public static CertificateIssue createCertificateIssue(
        Long certificateConfirmationNumber,
        Resident resident,
        String certificateTypeCode) {
        CertificateIssue certificateIssue = new CertificateIssue();
        certificateIssue.setCertificateConfirmationNumber(certificateConfirmationNumber);
        certificateIssue.setResident(resident);
        certificateIssue.setCertificateTypeCode(certificateTypeCode);
        certificateIssue.setCertificateIssueDate(LocalDate.now());
        return certificateIssue;
    }
}
