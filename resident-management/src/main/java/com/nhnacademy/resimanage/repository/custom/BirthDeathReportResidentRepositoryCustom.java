package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateParent;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateTarget;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportDto;
import com.nhnacademy.resimanage.entity.Resident;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BirthDeathReportResidentRepositoryCustom{
    BirthReportDto getBirthReportDtoBySerialNumbers(Integer reportSerialNumber, Integer targetSerialNumber);

    DeathReportDto getDeathReportDtoBySerialNumbers(Integer reportSerialNumber, Integer targetSerialNumber);

    BirthReportCertificateTarget getBirthReportTargetByTargetResident(Resident targetResident);

    List<BirthReportCertificateParent> getBirthReportParentByTargetResident(Resident targetResident);
}
