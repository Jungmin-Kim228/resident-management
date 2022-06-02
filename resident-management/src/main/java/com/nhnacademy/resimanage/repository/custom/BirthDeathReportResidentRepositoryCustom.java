package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportDto;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BirthDeathReportResidentRepositoryCustom{
    BirthReportDto getBirthReportDtoBySerialNumbers(Integer reportSerialNumber, Integer targetSerialNumber);

    DeathReportDto getDeathReportDtoBySerialNumbers(Integer reportSerialNumber, Integer targetSerialNumber);
}
