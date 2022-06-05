package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportModifyRequest;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportRequest;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateParent;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateReporter;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateTarget;
import com.nhnacademy.resimanage.entity.Resident;
import java.util.List;

public interface BirthReportService {
    BirthReportDto createBirthReport(Integer reportSerialNumber, BirthReportRequest request);

    BirthReportDto modifyBirthReport(Integer reportSerialNumber, Integer targetSerialNumber, BirthReportModifyRequest request);

    List<Integer> deleteBirthReport(Integer reportSerialNumber, Integer targetSerialNumber);

    BirthReportCertificateTarget getBirthReportTarget(Integer targetResidentNum);

    List<BirthReportCertificateParent> getBirthReportParent(Integer targetResidentNum);

    BirthReportCertificateReporter getBirthReportReporter(Integer targetResidentNum);
}
