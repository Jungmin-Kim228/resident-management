select BD.birth_death_type_code, BD.birth_death_report_date,
TR.name, TR.gender_code, TR.birth_date, TR.birth_place_code, TR.registration_base_address
from birth_death_report_resident BD
inner join resident TR on TR.resident_serial_number = BD.resident_serial_number
where BD.birth_death_type_code = '출생';

delete from birth_death_report_resident
where resident_serial_number = 8;

delete from family_relationship f
where f.base_resident_serial_number = 4 and f.family_resident_serial_number = 8;

delete from resident where resident_serial_number = 8;

insert into resident values(9, '아무개', '111111-1234567', '남', '19130914072200', '자택', '경기도 성남시 분당구 대왕판교로645번길', null, null, null);

select F.family_relationship_code as "구분", TR.name as "성명", DATE(TR.birth_date) as "출생년월일", TR.resident_registration_number as "주민등록번호", TR.gender_code as "성별"
from family_relationship F
inner join resident BR on BR.resident_serial_number = F.base_resident_serial_number
inner join resident TR on TR.resident_serial_number = F.family_resident_serial_number
where BR.resident_serial_number = 4;

select * from certificate_issue c order by c.certificate_issue_date desc, c.certificate_confirmation_number desc limit 1;

select C.certificate_type_code, BD.birth_death_report_date, R.resident_serial_number
from certificate_issue C
inner join resident R on C.resident_serial_number = R.resident_serial_number
inner join birth_death_report_resident BD on BD.resident_serial_number = R.resident_serial_number
where C.certificate_type_code = '출생신고서';

delete from certificate_issue where certificate_confirmation_number <= 1111111100001111;
delete from certificate_issue where certificate_confirmation_number <= 1234567800001111;
delete from certificate_issue where certificate_confirmation_number >= 9999999900000000;

-- 남기석 출생신고서 출생자 파트
select R.name, R.gender_code, R.birth_date, R.birth_place_code, R.registration_base_address
from resident R
inner join birth_death_report_resident BD on BD.resident_serial_number = R.resident_serial_number
where BD.birth_death_type_code = '출생'
and BD.resident_serial_number = 7;

-- 남기석 출생신고서 부모파트
select F.family_relationship_code , RM.name from family_relationship F
inner join resident RM on RM.resident_serial_number = F.family_resident_serial_number
where F.base_resident_serial_number = 7;

-- 남기석 출생신고서 신고인파트
select R.name, R.resident_registration_number, BD.birth_report_qualifications_code, BD.email_address, BD.phone_number 
from resident R
inner join birth_death_report_resident BD on R.resident_serial_number = BD.report_resident_serial_number
where BD.resident_serial_number = 7 and BD.birth_death_type_code = '출생';

-- 사망신고서 상단
select C.certificate_type_code, BD.birth_death_report_date
from certificate_issue C
inner join birth_death_report_resident BD on C.resident_serial_number = BD.resident_serial_number
where C.certificate_type_code = "사망신고서"
and BD.birth_death_type_code = "사망"
and BD.resident_serial_number = 1;

-- 사망신고서 사망자 파트
select R.name, R.resident_registration_number, R.death_date, R.death_place_code, R.death_place_address
from resident R
inner join birth_death_report_resident BD on R.resident_serial_number = BD.resident_serial_number
where BD.birth_death_type_code = '사망'
and R.resident_serial_number = 1;

-- 사망신고서 신고인 파트
select R.name, R.resident_registration_number, BD.death_report_qualifications_code, BD.email_address, BD.phone_number
from resident R
inner join birth_death_report_resident BD on R.resident_serial_number = BD.report_resident_serial_number
where BD.birth_death_type_code = '사망'
and BD.resident_serial_number = 1;

-- 증명서 발급 기록
select C.certificate_confirmation_number, C.certificate_type_code, C.certificate_issue_date
from certificate_issue C
where C.resident_serial_number = 4;

-- 주민등록등본 상단
select C.certificate_type_code, C.certificate_issue_date, C.certificate_confirmation_number
from certificate_issue C
where C.resident_serial_number = 4
and C.certificate_type_code = '주민등록등본'
order by C.certificate_issue_date desc limit 1;

-- 주민등록등본 세대주 파트
select R.name, H.household_composition_reason_code, H.household_composition_date
from resident R
inner join household H on H.household_resident_serial_number = R.resident_serial_number
where H.household_serial_number = 1;

-- 주민등록등본 주소 파트
select HM.last_address_yn, HM.house_movement_address, HM.house_movement_report_date
from household_movement_address HM
where HM.household_serial_number = 1
order by HM.house_movement_report_date desc;

-- 주민등록등본 세대주관계 파트
select HC.household_relationship_code, R.name, R.resident_registration_number, HC.report_date, HC.household_composition_change_reason_code
from household_composition_resident HC
inner join resident R on R.resident_serial_number = HC.resident_serial_number
where HC.household_serial_number = 1;