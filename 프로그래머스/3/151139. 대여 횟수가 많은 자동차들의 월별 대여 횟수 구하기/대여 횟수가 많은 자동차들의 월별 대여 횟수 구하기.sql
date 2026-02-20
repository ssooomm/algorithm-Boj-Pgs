with target as 
(select car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
group by car_id
having count(*) >=5)

select month(start_date) as month, car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (select car_id from target)
and START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
group by month, car_id
order by month, car_id desc