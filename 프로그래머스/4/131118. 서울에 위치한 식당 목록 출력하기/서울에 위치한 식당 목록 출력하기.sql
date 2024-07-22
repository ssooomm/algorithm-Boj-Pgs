-- 코드를 입력하세요
# SELECT i.REST_ID,i.REST_NAME,i.FOOD_TYPE,i.FAVORITES,i.ADDRESS,
# round(avg(r.review_score),3) as SCORE
# from REST_INFO i
# join REST_REVIEW r on i.rest_id = r.rest_id
# group by i.rest_id
# having i.address='서울%'
# order by score desc, favorites

select r.rest_id,i.REST_NAME,i.FOOD_TYPE,i.FAVORITES,i.ADDRESS,round(avg(r.review_score),2) as score
from rest_review r
join rest_info i on r.rest_id = i.rest_id
group by rest_id
having i.ADDRESS like '서울%'
order by score desc, i.FAVORITES desc


