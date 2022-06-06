package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.certificate.DeathReportCertificateReporter;
import com.nhnacademy.resimanage.domain.certificate.DeathReportCertificateTarget;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportDto;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportModifyRequest;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportRequest;
import java.util.List;

public interface DeathReportService {
    DeathReportDto createDeathReport(Integer reportSerialNumber, DeathReportRequest request);

    DeathReportDto modifyDeathReport(Integer reportSerialNumber, Integer targetSerialNumber, DeathReportModifyRequest request);

    List<Integer> deleteDeathReport(Integer reportSerialNumber, Integer targetSerialNumber);

    DeathReportCertificateTarget getDeathReportTarget(Integer targetResidentNum);

    DeathReportCertificateReporter getDeathReportReporter(Integer targetResidentNum);
}
