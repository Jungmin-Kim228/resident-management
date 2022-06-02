package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportRequest;
import com.nhnacademy.resimanage.entity.BirthDeathReportResident;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.BirthReportService;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BirthReportServiceImpl implements BirthReportService {
    private BirthDeathReportResidentRepository birthDeathReportResidentRepository;
    private ResidentRepository residentRepository;

    public BirthReportServiceImpl(
        BirthDeathReportResidentRepository birthDeathReportResidentRepository,
        ResidentRepository residentRepository) {
        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public BirthReportDto createBirthReport(Integer reportSerialNumber,
                                            BirthReportRequest request) {
        Resident resident =
            residentRepository.getResidentByResidentSerialNumber(request.getResidentSerialNumber());

        BirthDeathReportResident birthDeathReportResident =
            BirthDeathReportResident.addBirthReportResident()
                                    .reportResidentSerialNumber(reportSerialNumber)
                                    .resident(resident)
                                    .birthReportDate(request.getBirthDeathReportDate())
                                    .birthReportQualificationsCode(
                                        request.getBirthReportQualificationsCode())
                                    .emailAddress(
                                        Optional.ofNullable(request.getEmailAddress()).orElse(""))
                                    .phoneNumber(request.getPhoneNumber())
                                    .build();

        birthDeathReportResidentRepository.save(birthDeathReportResident);
        return birthDeathReportResidentRepository.getBirthReportDtoBySerialNumbers(
            reportSerialNumber, resident.getResidentSerialNumber());
    }
}
