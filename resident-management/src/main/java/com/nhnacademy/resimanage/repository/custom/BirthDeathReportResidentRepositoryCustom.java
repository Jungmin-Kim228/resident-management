package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateParent;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateReporter;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateTarget;
import com.nhnacademy.resimanage.domain.certificate.DeathReportCertificateReporter;
import com.nhnacademy.resimanage.domain.certificate.DeathReportCertificateTarget;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportDto;
import com.nhnacademy.resimanage.entity.Resident;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BirthDeathReportResidentRepositoryCustom{
    BirthReportDto getBirthReportDtoBySerialNumbers(Integer reportSerialNumber, Integer targetSerialNumber);

    DeathReportDto getDeathReportDtoBySerialNumbers(Integer reportSerialNumber, Integer targetSerialNumber);

    BirthReportCertificateTarget getBirthReportTargetByTargetResident(Integer targetResidentNum);

    List<BirthReportCertificateParent> getBirthReportParentByTargetResident(Integer targetResidentNum);

    BirthReportCertificateReporter getBirthReportReporterByTargetResident(Integer targetResidentNum);

    DeathReportCertificateTarget getDeathReportTargetByTargetResident(Integer targetResidentNum);

    DeathReportCertificateReporter getDeathReportReporterByTargetResident(Integer targetResidentNum);
}
