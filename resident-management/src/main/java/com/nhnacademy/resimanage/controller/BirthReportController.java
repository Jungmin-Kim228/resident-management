package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.domain.Output;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportModifyRequest;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportRequest;
import com.nhnacademy.resimanage.service.BirthReportService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/residents/{serialNumber}/birth")
public class BirthReportController {
    private final BirthReportService birthReportService;

    public BirthReportController(BirthReportService birthReportService) {
        this.birthReportService = birthReportService;
    }

    @PostMapping
    public Output createBirthReport(@PathVariable("serialNumber") Integer reportSerialNumber,
                                    @RequestBody BirthReportRequest request) {
        BirthReportDto birthReportDto = birthReportService.createBirthReport(reportSerialNumber, request);
        return Output.success(birthReportDto);
    }

    @PutMapping("/{targetSerialNumber}")
    public Output modifyBirthReport(@PathVariable("serialNumber") Integer reportSerialNumber,
                                    @PathVariable("targetSerialNumber") Integer targetSerialNumber,
                                    @RequestBody BirthReportModifyRequest request) {
        return null;
    }

    @DeleteMapping("/{targetSerialNumber}")
    public Output deleteBirthReport(@PathVariable("serialNumber") Integer reportSerialNumber,
                                    @PathVariable("targetSerialNumber") Integer targetSerialNumber) {
        return null;
    }
}
