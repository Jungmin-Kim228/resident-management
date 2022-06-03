package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.deathReport.DeathReportDto;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportModifyRequest;
import com.nhnacademy.resimanage.domain.deathReport.DeathReportRequest;
import com.nhnacademy.resimanage.entity.BirthDeathReportResident;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.DeathReportService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeathReportServiceImpl implements DeathReportService {
    private BirthDeathReportResidentRepository birthDeathReportResidentRepository;
    private ResidentRepository residentRepository;

    public DeathReportServiceImpl(
        BirthDeathReportResidentRepository birthDeathReportResidentRepository,
        ResidentRepository residentRepository) {
        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public DeathReportDto createDeathReport(Integer reportSerialNumber,
                                            DeathReportRequest request) {
        Resident resident =
            residentRepository.getResidentByResidentSerialNumber(request.getResidentSerialNumber());

        BirthDeathReportResident birthDeathReportResident =
            BirthDeathReportResident.addBirthDeathReportResident()
                                    .birthDeathTypecode("사망")
                                    .reportResidentSerialNumber(reportSerialNumber)
                                    .resident(resident)
                                    .birthDeathReportDate(request.getBirthDeathReportDate())
                                    .deathReportQualificationsCode(
                                        request.getDeathReportQualificationsCode())
                                    .emailAddress(
                                        Optional.ofNullable(request.getEmailAddress()).orElse(""))
                                    .phoneNumber(request.getPhoneNumber())
                                    .build();

        birthDeathReportResidentRepository.save(birthDeathReportResident);
        return birthDeathReportResidentRepository.getDeathReportDtoBySerialNumbers(
            reportSerialNumber, resident.getResidentSerialNumber());
    }

    @Transactional
    @Override
    public DeathReportDto modifyDeathReport(Integer reportSerialNumber, Integer targetSerialNumber,
                                            DeathReportModifyRequest request) {

        BirthDeathReportResident birthDeathReportResident =
            birthDeathReportResidentRepository.getBirthReportBySerialNumbers(reportSerialNumber,
                targetSerialNumber);

        birthDeathReportResident.setBirthDeathReportDate(
            Optional.ofNullable(request.getBirthDeathReportDate())
                    .orElse(birthDeathReportResident.getBirthDeathReportDate()));
        birthDeathReportResident.setDeathReportQualificationsCode(
            Optional.ofNullable(request.getDeathReportQualificationsCode())
                    .orElse(birthDeathReportResident.getBirthReportQualificationsCode()));
        birthDeathReportResident.setEmailAddress(
            Optional.ofNullable(request.getEmailAddress())
                    .orElse(birthDeathReportResident.getEmailAddress()));

        birthDeathReportResidentRepository.save(birthDeathReportResident);
        return birthDeathReportResidentRepository.getDeathReportDtoBySerialNumbers(
            reportSerialNumber, targetSerialNumber);
    }

    @Transactional
    @Override
    public List<Integer> deleteDeathReport(Integer reportSerialNumber, Integer targetSerialNumber) {
        BirthDeathReportResident birthDeathReportResident =
            birthDeathReportResidentRepository.getDeathReportBySerialNumbers(reportSerialNumber,
                targetSerialNumber);

        birthDeathReportResidentRepository.delete(birthDeathReportResident);
        return List.of(reportSerialNumber, targetSerialNumber);
    }
}
