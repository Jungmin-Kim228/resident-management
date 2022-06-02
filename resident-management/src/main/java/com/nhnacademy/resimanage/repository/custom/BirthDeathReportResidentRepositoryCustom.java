package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BirthDeathReportResidentRepositoryCustom{
    BirthReportDto getBirthReportDtoBySerialNumbers(Integer reportSerialNumber, Integer targetSerialNumber);
}
