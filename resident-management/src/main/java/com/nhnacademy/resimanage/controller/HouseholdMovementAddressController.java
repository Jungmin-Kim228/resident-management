package com.nhnacademy.resimanage.controller;

import com.nhnacademy.resimanage.domain.Output;
import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressDto;
import com.nhnacademy.resimanage.domain.householdMovementAddress.HouseholdMovementAddressRequest;
import com.nhnacademy.resimanage.service.HouseholdMovementAddressService;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/household/{householdSerialNumber}/movement")
public class HouseholdMovementAddressController {
    private HouseholdMovementAddressService householdMovementAddressService;

    public HouseholdMovementAddressController(
        HouseholdMovementAddressService householdMovementAddressService) {
        this.householdMovementAddressService = householdMovementAddressService;
    }

    @PostMapping
    public Output createHouseholdMoveAddr(
        @PathVariable("householdSerialNumber") Integer householdSerialNumber,
        @RequestBody HouseholdMovementAddressRequest request) {

        HouseholdMovementAddressDto householdMovementAddressDto = householdMovementAddressService.createHouseholdMovementAddress(householdSerialNumber, request);
        return Output.success(householdMovementAddressDto);
    }

    @PutMapping("/{reportDate}")
    public Output modifyHouseholdMoveAddr(
        @PathVariable("householdSerialNumber") Integer householdSerialNumber,
        @PathVariable("reportDate") LocalDate reportDate) {
        return null;
    }

    @DeleteMapping("/{reportDate}")
    public Output deleteHouseholdMoveAddr(
        @PathVariable("householdSerialNumber") Integer householdSerialNumber,
        @PathVariable("reportDate") LocalDate reportDate) {
        return null;
    }
}
