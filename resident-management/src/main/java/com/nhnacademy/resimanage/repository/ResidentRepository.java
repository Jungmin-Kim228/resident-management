package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.domain.resident.ResidentDto;
import com.nhnacademy.resimanage.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Integer> {
    ResidentDto getResidentDtoByResidentSerialNumber(Integer residentSerialNumber);

    Resident getResidentByResidentSerialNumber(Integer residentSerialNumber);
}
