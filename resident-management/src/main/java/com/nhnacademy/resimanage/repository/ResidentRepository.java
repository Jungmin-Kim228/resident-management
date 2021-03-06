package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.domain.resident.ResidentDto;
import com.nhnacademy.resimanage.entity.Resident;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Integer> {
    ResidentDto getResidentDtoByResidentSerialNumber(Integer residentSerialNumber);

    Resident getResidentByResidentSerialNumber(Integer residentSerialNumber);

    Page<Resident> getAllBy(Pageable pageable);
}
