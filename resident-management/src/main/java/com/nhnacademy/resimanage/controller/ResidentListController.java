package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.service.ResidentService;
import java.util.List;
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
    public String residentList(Model model) {
        List<Resident> residents = residentService.getAllResidents();
        model.addAttribute("residentList", residents);
        return "residentList";
    }
}
