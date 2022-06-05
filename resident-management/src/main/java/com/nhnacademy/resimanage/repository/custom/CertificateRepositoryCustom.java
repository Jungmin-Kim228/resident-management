package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CertificateRepositoryCustom {
    BirthDeathReportCertificateTop getBirthReportTopByTargetResident(Integer targetResidentNum);

    BirthDeathReportCertificateTop getDeathReportTopByTargetResident(Integer targetResidentNum);
}
