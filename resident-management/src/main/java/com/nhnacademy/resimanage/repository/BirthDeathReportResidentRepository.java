package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.entity.BirthDeathReportResident;
import com.nhnacademy.resimanage.repository.custom.BirthDeathReportResidentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BirthDeathReportResidentRepository
    extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk>,
    BirthDeathReportResidentRepositoryCustom {

    @Query("select i from BirthDeathReportResident i where i.pk.birthDeathTypeCode = '출생' and i.pk.reportResidentSerialNumber = ?1 and i.pk.residentSerialNumber = ?2")
    BirthDeathReportResident getBirthReportBySerialNumbers(Integer reportSerialNumber, Integer targetSerialNumber);

    @Query("select i from BirthDeathReportResident i where i.pk.birthDeathTypeCode = '사망' and i.pk.reportResidentSerialNumber = ?1 and i.pk.residentSerialNumber = ?2")
    BirthDeathReportResident getDeathReportBySerialNumbers(Integer reportSerialNumber, Integer targetSerialNumber);
}
