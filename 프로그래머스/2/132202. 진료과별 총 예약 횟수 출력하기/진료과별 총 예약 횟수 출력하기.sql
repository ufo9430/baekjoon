-- 코드를 입력하세요
SELECT MCDP_CD as '진료과코드',
COUNT(APNT_NO) as '5월예약건수'
from APPOINTMENT
WHERE YEAR(APNT_YMD) = '2022' and MONTH(APNT_YMD) = '5'
group by MCDP_CD
order by COUNT(APNT_NO) asc, MCDP_CD asc