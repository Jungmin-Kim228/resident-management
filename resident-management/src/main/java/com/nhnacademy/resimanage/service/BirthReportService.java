package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportModifyRequest;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportRequest;
import java.util.List;

public interface BirthReportService {
    BirthReportDto createBirthReport(Integer reportSerialNumber, BirthReportRequest request);

    BirthReportDto modifyBirthReport(Integer reportSerialNumber, Integer targetSerialNumber, BirthReportModifyRequest request);

    List<Integer> deleteBirthReport(Integer reportSerialNumber, Integer targetSerialNumber);
}
