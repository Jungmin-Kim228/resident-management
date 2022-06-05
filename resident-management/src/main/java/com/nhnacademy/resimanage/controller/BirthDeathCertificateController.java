package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.domain.certificate.BirthDeathReportCertificateTop;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateParent;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateReporter;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateTarget;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.service.BirthReportService;
import com.nhnacademy.resimanage.service.CertificateIssueService;
import com.nhnacademy.resimanage.service.DeathReportService;
import com.nhnacademy.resimanage.service.ResidentService;
import java.util.List;
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
        certificateIssueService.createCertificate(targetResidentNum, "출생신고서");

        BirthDeathReportCertificateTop birthDeathReportCertificateTop = certificateIssueService.getBirthReportTop(targetResidentNum);
        BirthReportCertificateTarget birthReportCertificateTarget = birthReportService.getBirthReportTarget(targetResidentNum);
        List<BirthReportCertificateParent> birthReportCertificateParentList = birthReportService.getBirthReportParent(targetResidentNum);
        BirthReportCertificateReporter birthReportCertificateReporter = birthReportService.getBirthReportReporter(targetResidentNum);

        model.addAttribute("birthDeathReportCertificateTop",birthDeathReportCertificateTop);
        model.addAttribute("birthReportCertificateTarget", birthReportCertificateTarget);
        model.addAttribute("birthReportCertificateParent", birthReportCertificateParentList);
        model.addAttribute("birthReportCertificateReporter", birthReportCertificateReporter);

        return "birthReport";
    }

    @PostMapping("/deathCertificateView")
    public String getDeathReport(@RequestParam("targetResidentNum") Integer targetResidentNum, Model model) {
        certificateIssueService.createCertificate(targetResidentNum, "사망신고서");

        BirthDeathReportCertificateTop birthDeathReportCertificateTop = certificateIssueService.getDeathReportTop(targetResidentNum);

        model.addAttribute("birthDeathReportCertificateTop", birthDeathReportCertificateTop);

        return "deathReport";
    }
}
