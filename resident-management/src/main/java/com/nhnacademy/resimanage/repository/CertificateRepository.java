package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.entity.CertificateIssue;
import com.nhnacademy.resimanage.repository.custom.CertificateRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CertificateRepository extends JpaRepository<CertificateIssue, Long>,
    CertificateRepositoryCustom {

    @Query("select count(c.certificateConfirmationNumber) from CertificateIssue c")
    Long getCount();

    @Query(value = "SELECT * FROM certificate_issue c ORDER BY c.certificate_issue_date desc, c.certificate_confirmation_number DESC LIMIT 1", nativeQuery = true)
    CertificateIssue getLastBy();
}
