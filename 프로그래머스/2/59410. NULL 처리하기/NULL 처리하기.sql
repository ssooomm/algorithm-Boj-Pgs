-- 코드를 입력하세요
SELECT ANIMAL_TYPE,case
when name is null then 'No name'
else name
end as name
,SEX_UPON_INTAKE
FROM ANIMAL_INS 
order by ANIMAL_ID