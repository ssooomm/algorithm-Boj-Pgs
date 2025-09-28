-- 코드를 입력하세요
select ri.rest_id, ri.rest_name, ri.food_type, ri.favorites, ri.address, round(avg(review_score),2) as score
from rest_info ri
join rest_review rr
	on ri.rest_id = rr.rest_id
where ri.address like '서울%'
group by ri.rest_id -- ri.rest_name, ri.address 로도 그룹화 가능(중복이 없는 값들)
order by 6 desc, 4 desc