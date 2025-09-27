-- 코드를 입력하세요
SELECT p.PRODUCT_ID,PRODUCT_NAME,sum(price * amount) as TOTAL_SALES
from FOOD_PRODUCT p
join FOOD_ORDER o on p.PRODUCT_ID = o.PRODUCT_ID
where PRODUCE_DATE like '2022-05%'
group by PRODUCT_NAME
order by TOTAL_SALES desc, PRODUCT_ID