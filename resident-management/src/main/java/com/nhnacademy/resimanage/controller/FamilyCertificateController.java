package com.nhnacademy.resimanage.controller;

import static java.time.LocalDate.now;

import com.nhnacademy.resimanage.domain.certificate.FamilyCertificateBot;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.service.CertificateIssueService;
import com.nhnacademy.resimanage.service.FamilyRelationshipService;
import com.nhnacademy.resimanage.service.ResidentService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FamilyCertificateController {
    private final CertificateIssueService certificateIssueService;
    private final ResidentService residentService;
    private final FamilyRelationshipService familyRelationshipService;

    public FamilyCertificateController(CertificateIssueService certificateIssueService,
                                       ResidentService residentService,
                                       FamilyRelationshipService familyRelationshipService) {
        this.certificateIssueService = certificateIssueService;
        this.residentService = residentService;
        this.familyRelationshipService = familyRelationshipService;
    }

    @PostMapping("/familyCertificateView")
    public String prepareView(@RequestParam("baseResidentNum") Integer baseNum, Model model) {
        Resident baseResident = residentService.getResidentBySerialNum(baseNum);
        String registrationBaseAddress = baseResident.getRegistrationBaseAddress();

        certificateIssueService.createCertificate(baseResident, "가족관계증명서");

        // here 여기 해야함
        List<FamilyCertificateBot> familyCertificateBotList = familyRelationshipService.findFamilyRelationshipByBaseResidentNum(baseNum);

        return "redirect:/familyCertificateView";
    }

    @GetMapping("/familyCertificateView")
    public String executeView() {
        return "familyRelationship";
    }
}
