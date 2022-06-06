package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.domain.certificate.CertificateRecord;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CertificateRepositoryCustom {
    BirthDeathReportCertificateTop getBirthReportTopByTargetResident(Integer targetResidentNum);

    BirthDeathReportCertificateTop getDeathReportTopByTargetResident(Integer targetResidentNum);

    List<CertificateRecord> getCertificateRecodeByResident(Integer residentNum);
}
