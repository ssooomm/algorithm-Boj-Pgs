-- 코드를 입력하세요
SELECT USER_ID,NICKNAME,sum(price) as TOTAL_SALES
from USED_GOODS_BOARD b
join USED_GOODS_USER u
on b.WRITER_ID = u.USER_ID
where STATUS = 'done'
group by WRITER_ID
having sum(price)>=700000
order by sum(price)