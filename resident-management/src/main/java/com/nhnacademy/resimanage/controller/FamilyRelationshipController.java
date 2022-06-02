package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.domain.Output;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipDto;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipModifyRequest;
import com.nhnacademy.resimanage.domain.familyRelationship.FamilyRelationshipRequest;
import com.nhnacademy.resimanage.service.FamilyRelationshipService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/residents/{serialNumber}/relationship")
public class FamilyRelationshipController {
    private final FamilyRelationshipService familyRelationshipService;

    public FamilyRelationshipController(FamilyRelationshipService familyRelationshipService) {
        this.familyRelationshipService = familyRelationshipService;
    }

    @PostMapping
    public Output createFamilyRelationship(
        @PathVariable("serialNumber") Integer baseResidentSerialNumber,
        @RequestBody FamilyRelationshipRequest request) {

        FamilyRelationshipDto familyRelationshipDto =
            familyRelationshipService.createRelationship(baseResidentSerialNumber, request);
        return Output.success(familyRelationshipDto);
    }

    @PutMapping("/{familySerialNumber}")
    public Output modifyFamilyRelationship(
        @PathVariable("serialNumber") Integer baseResidentSerialNumber,
        @PathVariable("familySerialNumber") Integer familyResidentSerialNumber,
        @RequestBody FamilyRelationshipModifyRequest request) {

        FamilyRelationshipDto familyRelationshipDto =
            familyRelationshipService.modifyRelationship(baseResidentSerialNumber,
                familyResidentSerialNumber, request);
        return Output.success(familyRelationshipDto);
    }

    @DeleteMapping("/{familySerialNumber}")
    public Output deleteFamilyRelationship(
        @PathVariable("serialNumber") Integer baseResidentSerialNumber,
        @PathVariable("familySerialNumber") Integer familyResidentSerialNumber) {

        List<Integer> serialNumbers =
            familyRelationshipService.deleteRelationship(baseResidentSerialNumber,
                familyResidentSerialNumber);
        return Output.success(serialNumbers);
    }
}
