package com.nhnacademy.resimanage.domain.certificate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyCertificateBotSelf {
    String familyRelationshipCode;
    String name;
    String birthDate;
    String residentRegistrationNumber;
    String genderCode;

    @Builder(builderMethodName = "newFamilyBotSelf")
    public static FamilyCertificateBotSelf newFamilyCertificateBotSelf(String code, String name,
                                                               LocalDate birthDate,
                                                               String registrationNum,
                                                               String genderCode) {
        FamilyCertificateBotSelf familyCertificateBotSelf = new FamilyCertificateBotSelf();
        familyCertificateBotSelf.setFamilyRelationshipCode(code);
        familyCertificateBotSelf.setName(name);
        familyCertificateBotSelf.setBirthDate(birthDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
        familyCertificateBotSelf.setResidentRegistrationNumber(registrationNum);
        familyCertificateBotSelf.setGenderCode(genderCode);
        return familyCertificateBotSelf;
    }
}
