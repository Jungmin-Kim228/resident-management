package com.nhnacademy.resimanage.domain.certificate;

import java.time.LocalDate;

//@Getter
//@Setter
public interface FamilyCertificateBot {
    String getFamilyRelationshipCode();
    String getName();
    String getBirthDate();
    String getResidentRegistrationNumber();
    String getGenderCode();

//    @Builder(builderMethodName = "newFamilyBot")
//    public static FamilyCertificateBot newFamilyCertificateBot(String code, String name,
//                                                               LocalDate birthDate,
//                                                               String registrationNum,
//                                                               String genderCode) {
//        FamilyCertificateBot familyCertificateBot = new FamilyCertificateBot();
//        familyCertificateBot.setFamilyRelationshipCode(code);
//        familyCertificateBot.setName(name);
//        familyCertificateBot.setBirthDate(birthDate);
//        familyCertificateBot.setResidentRegistrationNumber(registrationNum);
//        familyCertificateBot.setGenderCode(genderCode);
//        return familyCertificateBot;
//    }
}
