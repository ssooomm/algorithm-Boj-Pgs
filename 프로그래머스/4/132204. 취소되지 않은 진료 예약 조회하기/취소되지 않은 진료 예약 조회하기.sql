-- 코드를 입력하세요
SELECT APNT_NO,PT_NAME,a.PT_NO,a.MCDP_CD,DR_NAME,APNT_YMD
from APPOINTMENT a
join PATIENT p on a.PT_NO = p.PT_NO
join DOCTOR d on a.MDDR_ID = d.DR_ID
where APNT_YMD like '2022-04-13%' and a.MCDP_CD = 'cs' and APNT_CNCL_YMD is null
order by APNT_YMD