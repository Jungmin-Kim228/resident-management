package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.domain.certificate.CertificateRecord;
import com.nhnacademy.resimanage.entity.CertificateIssue;
import com.nhnacademy.resimanage.repository.custom.CertificateRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CertificateRepository extends JpaRepository<CertificateIssue, Long>,
    CertificateRepositoryCustom {

    @Query("select count(c.certificateConfirmationNumber) from CertificateIssue c")
    Long getCount();

    @Query(value = "select * from certificate_issue c order by c.certificate_issue_date desc, c.certificate_confirmation_number desc LIMIT 1", nativeQuery = true)
    CertificateIssue getLastBy();

    Page<CertificateIssue> getAllByResident_ResidentSerialNumber(Pageable pageable, Integer residentNum);
}
