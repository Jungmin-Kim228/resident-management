package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.entity.BirthDeathReportResident;
import com.nhnacademy.resimanage.repository.custom.BirthDeathReportResidentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthDeathReportResidentRepository
    extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk>,
    BirthDeathReportResidentRepositoryCustom {

}
