-- 코드를 작성해주세요
select count(*) as fish_count, fish_name
from FISH_INFO i
join FISH_NAME_INFO n on i.FISH_TYPE = n.FISH_TYPE
group by FISH_NAME
ORDER BY FISH_COUNT DESC;