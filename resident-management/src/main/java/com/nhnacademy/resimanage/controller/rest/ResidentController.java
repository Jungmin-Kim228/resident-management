package com.nhnacademy.resimanage.controller.rest;

import com.nhnacademy.resimanage.domain.Output;
import com.nhnacademy.resimanage.domain.resident.ResidentDto;
import com.nhnacademy.resimanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.resimanage.domain.resident.ResidentRequest;
import com.nhnacademy.resimanage.service.ResidentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/residents")
public class ResidentController {
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public Output createResident(@RequestBody ResidentRequest request) {
        ResidentDto residentDto = residentService.createResident(request);
        return Output.success(residentDto);
    }

    @PutMapping("/{serialNumber}")
    public Output modifyResident(@PathVariable("serialNumber") Integer residentSerialNumber,
                                 @RequestBody ResidentModifyRequest request) {
        ResidentDto residentDto = residentService.modifyResident(residentSerialNumber, request);
        return Output.success(residentDto);
    }

    @DeleteMapping("/{serialNumber}")
    public Output deleteResident(@PathVariable("serialNumber") Integer residentSerialNumber) {
        return null;
    }
}
