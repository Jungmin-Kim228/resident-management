package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.entity.Resident;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CertificateRepositoryCustom {
    BirthDeathReportCertificateTop getBirthReportTopByTargetResident(Resident targetResident);
}
