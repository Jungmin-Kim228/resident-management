package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportRequest;

public interface BirthReportService {
    BirthReportDto createBirthReport(Integer reportSerialNumber, BirthReportRequest request);
}
