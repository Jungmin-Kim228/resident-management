package com.nhnacademy.resimanage.service;

import com.nhnacademy.resimanage.domain.resident.ResidentDto;
import com.nhnacademy.resimanage.domain.resident.ResidentRequest;

public interface ResidentService {
    ResidentDto createResident(ResidentRequest request);
}
