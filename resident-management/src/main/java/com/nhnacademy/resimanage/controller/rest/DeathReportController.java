package com.nhnacademy.resimanage.controller.rest;

import com.nhnacademy.resimanage.domain.Output;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportDto;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportModifyRequest;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportRequest;
import com.nhnacademy.resimanage.service.DeathReportService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/residents/{serialNumber}/death")
public class DeathReportController {
    private final DeathReportService deathReportService;

    public DeathReportController(DeathReportService deathReportService) {
        this.deathReportService = deathReportService;
    }

    @PostMapping
    public Output createDeathReport(@PathVariable("serialNumber") Integer reportSerialNumber,
                                    @RequestBody DeathReportRequest request) {
        DeathReportDto
            deathReportDto = deathReportService.createDeathReport(reportSerialNumber, request);
        return Output.success(deathReportDto);
    }

    @PutMapping("/{targetSerialNumber}")
    public Output modifyDeathReport(@PathVariable("serialNumber") Integer reportSerialNumber,
                                    @PathVariable("targetSerialNumber") Integer targetSerialNumber,
                                    @RequestBody DeathReportModifyRequest request) {
        DeathReportDto deathReportDto = deathReportService.modifyDeathReport(reportSerialNumber, targetSerialNumber, request);
        return Output.success(deathReportDto);
    }

    @DeleteMapping("/{targetSerialNumber}")
    public Output deleteDeathReport(@PathVariable("serialNumber") Integer reportSerialNumber,
                                    @PathVariable("targetSerialNumber") Integer targetSerialNumber) {
        List<Integer> serialNumbers = deathReportService.deleteDeathReport(reportSerialNumber, targetSerialNumber);
        return Output.success(serialNumbers);
    }
}
