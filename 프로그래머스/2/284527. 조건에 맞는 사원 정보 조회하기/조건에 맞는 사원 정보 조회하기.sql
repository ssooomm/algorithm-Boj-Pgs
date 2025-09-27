-- 코드를 작성해주세요
select sum(score) as score,e.EMP_NO,EMP_NAME,POSITION,EMAIL
from HR_EMPLOYEES e
join HR_GRADE g on e.EMP_NO = g.EMP_NO
where year = '2022'
group by g.emp_no
order by score desc
limit 1;