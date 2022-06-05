package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.service.BirthReportService;
import com.nhnacademy.resimanage.service.CertificateIssueService;
import com.nhnacademy.resimanage.service.DeathReportService;
import com.nhnacademy.resimanage.service.ResidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BirthDeathCertificateController {
    private final BirthReportService birthReportService;
    private final DeathReportService deathReportService;
    private final CertificateIssueService certificateIssueService;
    private final ResidentService residentService;

    public BirthDeathCertificateController(
        BirthReportService birthReportService,
        DeathReportService deathReportService,
        CertificateIssueService certificateIssueService,
        ResidentService residentService) {
        this.birthReportService = birthReportService;
        this.deathReportService = deathReportService;
        this.certificateIssueService = certificateIssueService;
        this.residentService = residentService;
    }

    @PostMapping("/birthCertificateView")
    public String getBirthReport(@RequestParam("targetResidentNum") Integer targetResidentNum, Model model) {
        Resident targetResident = residentService.getResidentBySerialNum(targetResidentNum);
        certificateIssueService.createCertificate(targetResident, "출생신고서");

        BirthDeathReportCertificateTop birthDeathReportCertificateTop = certificateIssueService.getBirthReportTop(targetResident);

        model.addAttribute("birthDeathReportCertificateTop",birthDeathReportCertificateTop);

        return "birthReport";
    }

    @PostMapping("/deathCertificateView")
    public String getDeathReport(@RequestParam("targetResidentNum") Integer targetResidentNum, Model model) {
        Resident targetResident = residentService.getResidentBySerialNum(targetResidentNum);
        certificateIssueService.createCertificate(targetResident, "사망신고서");

        BirthDeathReportCertificateTop birthDeathReportCertificateTop = certificateIssueService.getDeathReportTop(targetResident);

        model.addAttribute("birthDeathReportCertificateTop", birthDeathReportCertificateTop);

        return "deathReport";
    }
}
