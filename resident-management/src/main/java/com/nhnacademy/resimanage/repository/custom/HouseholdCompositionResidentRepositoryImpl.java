package com.nhnacademy.resimanage.repository.custom;

import com.nhnacademy.resimanage.entity.HouseholdCompositionResident;
import com.nhnacademy.resimanage.entity.QHouseholdCompositionResident;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class HouseholdCompositionResidentRepositoryImpl extends QuerydslRepositorySupport
    implements HouseholdCompositionResidentRepositoryCustom {
    public HouseholdCompositionResidentRepositoryImpl() {
        super(HouseholdCompositionResident.class);
    }

    @Override
    public Integer getHouseholdSerialNumByResident(Integer residentNum) {
        QHouseholdCompositionResident householdCompositionResident = QHouseholdCompositionResident.householdCompositionResident;

        return from(householdCompositionResident)
            .where(householdCompositionResident.pk.residentSerialNumber.eq(residentNum))
            .select(householdCompositionResident.pk.householdSerialNumber)
            .fetchOne();
    }
}
