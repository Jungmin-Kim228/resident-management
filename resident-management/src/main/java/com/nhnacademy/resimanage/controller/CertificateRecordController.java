package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.domain.certificate.CertificateRecord;
import com.nhnacademy.resimanage.service.CertificateIssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String certificateRecordView(@RequestParam("residentNum") Integer residentNum,
                                        Pageable pageable, Model model) {
        Page<CertificateRecord> certificateRecord = certificateIssueService.getCertificateRecords(pageable, residentNum);

        model.addAttribute("pages", certificateRecord);
        model.addAttribute("maxPage", 3);
        model.addAttribute("residentNum", residentNum);
        return "certificationList";
    }

    @GetMapping("/certificateRecordView")
    public String certificateRecordViewPage(@RequestParam("residentNum") Integer residentNum,
                                            Pageable pageable, Model model) {
        Page<CertificateRecord> certificateRecord = certificateIssueService.getCertificateRecords(pageable, residentNum);

        model.addAttribute("pages", certificateRecord);
        model.addAttribute("maxPage", 3);
        model.addAttribute("residentNum", residentNum);
        return "certificationList";
    }
}
