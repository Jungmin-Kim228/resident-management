package com.nhnacademy.resimanage.controller.rest;

import com.nhnacademy.resimanage.domain.Output;
import com.nhnacademy.resimanage.domain.household.HouseholdDto;
import com.nhnacademy.resimanage.domain.household.HouseholdRequest;
import com.nhnacademy.resimanage.service.HouseholdService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/household")
public class HouseholdController {
    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping
    public Output createHousehold(@RequestBody HouseholdRequest request) {

        HouseholdDto householdDto = householdService.createHousehold(request);
        return Output.success(householdDto);
    }

    @DeleteMapping("/{householdSerialNumber}")
    public Output deleteHousehold(
        @PathVariable("householdSerialNumber") Integer householdSerialNumber) {

        Integer serialNumber = householdService.deleteHousehold(householdSerialNumber);
        return Output.success(serialNumber);
    }
}
