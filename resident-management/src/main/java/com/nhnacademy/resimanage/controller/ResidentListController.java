package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.domain.certificate.ResidentListDto;
import com.nhnacademy.resimanage.service.ResidentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResidentListController {
    private final ResidentService residentService;

    public ResidentListController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping("/residentList")
    public String residentList(Pageable pageable, Model model) {
        Page<ResidentListDto> residents = residentService.getAllResidents(pageable);
        model.addAttribute("pages", residents);
        model.addAttribute("maxPage", 3);
        return "residentList";
    }
}
