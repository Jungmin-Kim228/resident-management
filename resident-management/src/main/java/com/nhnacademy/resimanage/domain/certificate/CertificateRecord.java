package com.nhnacademy.resimanage.domain.certificate;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CertificateRecord {
    Long certificateConfirmationNumber;
    String certificateTypeCode;
    LocalDate certificateIssueDate;
}
