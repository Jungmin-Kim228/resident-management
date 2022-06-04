package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.resident.ResidentDto;
import com.nhnacademy.resimanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.resimanage.domain.resident.ResidentRequest;
import com.nhnacademy.resimanage.entity.Resident;
import java.util.List;

public interface ResidentService {
    ResidentDto createResident(ResidentRequest request);

    ResidentDto modifyResident(Integer residentSerialNumber, ResidentModifyRequest request);

    List<Resident> getAllResidents();

    Resident getResidentBySerialNum(Integer residentSerialNumber);
}
