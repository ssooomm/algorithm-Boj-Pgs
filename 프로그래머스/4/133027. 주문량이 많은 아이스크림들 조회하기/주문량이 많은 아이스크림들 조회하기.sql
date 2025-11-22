-- 코드를 입력하세요
SELECT f.FLAVOR
from FIRST_HALF f
join JULY j
on f.flavor = j.flavor
group by f.FLAVOR, j.flavor
order by sum(f.TOTAL_ORDER + j.TOTAL_ORDER) desc
limit 3;