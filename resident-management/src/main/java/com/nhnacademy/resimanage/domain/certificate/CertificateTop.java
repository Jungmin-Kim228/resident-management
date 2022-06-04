package com.nhnacademy.resimanage.domain.certificate;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificateTop {
    String certificateTypeCode; // certificateIssue
    LocalDate certificateIssueDate; // certificateIssue
    Long certificateConfirmationNumber; // certificateIssue
}
