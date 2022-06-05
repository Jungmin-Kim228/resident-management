package com.nhnacademy.resimanage.service.impl;

import com.nhnacademy.resimanage.domain.birthReport.BirthReportDto;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportModifyRequest;
import com.nhnacademy.resimanage.domain.birthReport.BirthReportRequest;
import com.nhnacademy.resimanage.domain.certificate.BirthReportCertificateTarget;
import com.nhnacademy.resimanage.entity.BirthDeathReportResident;
import com.nhnacademy.resimanage.entity.Resident;
import com.nhnacademy.resimanage.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.resimanage.repository.ResidentRepository;
import com.nhnacademy.resimanage.service.BirthReportService;
import java.util.List;
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
            BirthDeathReportResident.addBirthDeathReportResident()
                                    .birthDeathTypecode("출생")
                                    .reportResidentSerialNumber(reportSerialNumber)
                                    .resident(resident)
                                    .birthDeathReportDate(request.getBirthDeathReportDate())
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

    @Transactional
    @Override
    public BirthReportDto modifyBirthReport(Integer reportSerialNumber, Integer targetSerialNumber,
                                            BirthReportModifyRequest request) {

        BirthDeathReportResident birthDeathReportResident =
            birthDeathReportResidentRepository.getBirthReportBySerialNumbers(reportSerialNumber,
                targetSerialNumber);

        birthDeathReportResident.setBirthDeathReportDate(
            Optional.ofNullable(request.getBirthDeathReportDate())
                    .orElse(birthDeathReportResident.getBirthDeathReportDate()));
        birthDeathReportResident.setBirthReportQualificationsCode(
            Optional.ofNullable(request.getBirthReportQualificationsCode())
                    .orElse(birthDeathReportResident.getBirthReportQualificationsCode()));
        birthDeathReportResident.setEmailAddress(
            Optional.ofNullable(request.getEmailAddress())
                    .orElse(birthDeathReportResident.getEmailAddress()));

        birthDeathReportResidentRepository.save(birthDeathReportResident);
        return birthDeathReportResidentRepository.getBirthReportDtoBySerialNumbers(
            reportSerialNumber, targetSerialNumber);
    }

    @Transactional
    @Override
    public List<Integer> deleteBirthReport(Integer reportSerialNumber, Integer targetSerialNumber) {
        BirthDeathReportResident birthDeathReportResident =
            birthDeathReportResidentRepository.getBirthReportBySerialNumbers(reportSerialNumber,
                targetSerialNumber);

        birthDeathReportResidentRepository.delete(birthDeathReportResident);
        return List.of(reportSerialNumber, targetSerialNumber);
    }

    @Override
    public BirthReportCertificateTarget getBirthReportTarget(Resident targetResident) {
        return birthDeathReportResidentRepository.getBirthReportTargetByTargetResident(targetResident);
    }
}
