package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.certificate.ResidentListDto;
import com.nhnacademy.resimanage.domain.resident.ResidentDto;
import com.nhnacademy.resimanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.resimanage.domain.resident.ResidentRequest;
import com.nhnacademy.resimanage.entity.Resident;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResidentService {
    ResidentDto createResident(ResidentRequest request);

    ResidentDto modifyResident(Integer residentSerialNumber, ResidentModifyRequest request);

    Page<ResidentListDto> getAllResidents(Pageable pageable);

    Resident getResidentBySerialNum(Integer residentSerialNumber);
}
