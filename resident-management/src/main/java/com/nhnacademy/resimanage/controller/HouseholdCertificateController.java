package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateAddress;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateHouseholder;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateRelationship;
import com.nhnacademy.resimanage.domain.certificate.HouseholdCertificateTop;
import com.nhnacademy.resimanage.repository.HouseholdRepository;
import com.nhnacademy.resimanage.service.CertificateIssueService;
import com.nhnacademy.resimanage.service.HouseholdService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HouseholdCertificateController {
    private HouseholdService householdService;
    private CertificateIssueService certificateIssueService;

    public HouseholdCertificateController(
        HouseholdService householdService,
        CertificateIssueService certificateIssueService) {
        this.householdService = householdService;
        this.certificateIssueService = certificateIssueService;
    }

    @PostMapping("householdCertificateView")
    public String householdCertificate(@RequestParam("residentNum") Integer residentNum, Model model) {
        certificateIssueService.createCertificate(residentNum, "주민등록등본");
        HouseholdCertificateTop householdCertificateTop = householdService.getHouseholdCertificateTop(residentNum);
        HouseholdCertificateHouseholder householdCertificateHouseholder = householdService.getHouseholdCertificateHouseholder(residentNum);
        List<HouseholdCertificateAddress> householdCertificateAddress = householdService.getHouseholdCertificateAddress(residentNum);
        List<HouseholdCertificateRelationship> householdCertificateRelationship = householdService.getHouseholdCertificateRelationship(residentNum);

        model.addAttribute("householdCertificateTop", householdCertificateTop);
        model.addAttribute("householdCertificateHouseholder", householdCertificateHouseholder);
        model.addAttribute("householdCertificateAddress", householdCertificateAddress);
        model.addAttribute("householdCertificateRelationship", householdCertificateRelationship);

        return "household";
    }
}
