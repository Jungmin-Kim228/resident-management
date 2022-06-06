package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.domain.certificate.CertificateRecord;
import com.nhnacademy.resimanage.service.CertificateIssueService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CertificateRecordController {
    private final CertificateIssueService certificateIssueService;

    public CertificateRecordController(
        CertificateIssueService certificateIssueService) {
        this.certificateIssueService = certificateIssueService;
    }

    @PostMapping("/certificateRecordView")
    public String certificateRecodeView(@RequestParam("residentNum") Integer residentNum, Model model) {
        List<CertificateRecord> certificateRecord = certificateIssueService.getCertificateRecord(residentNum);

        model.addAttribute("certificateRecord", certificateRecord);
        return "certificationList";
    }
}
