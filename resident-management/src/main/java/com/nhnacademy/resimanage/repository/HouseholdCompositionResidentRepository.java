package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.entity.HouseholdCompositionResident;
import com.nhnacademy.resimanage.repository.custom.HouseholdCompositionResidentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk>,
    HouseholdCompositionResidentRepositoryCustom {

}
