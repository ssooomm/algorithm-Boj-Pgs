

with r as (
select CAR_TYPE,DISCOUNT_RATE
from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
where DURATION_TYPE = '30일 이상'
and CAR_TYPE in ('세단','suv')
    )


SELECT CAR_ID,c.CAR_TYPE,CEIL((DAILY_FEE*(100-DISCOUNT_RATE)/100)*30) as FEE
from CAR_RENTAL_COMPANY_CAR c
join r on c.CAR_TYPE = r.CAR_TYPE
where c.CAR_TYPE in ('세단','suv')
and car_id not in (
select car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE <='2022-11-30'
    and END_DATE >= '2022-11-01'
group by car_id
)
and (DAILY_FEE*(100-DISCOUNT_RATE)/100)*30 between 500000 and 2000000
order by fee desc,CAR_TYPE, CAR_ID desc
