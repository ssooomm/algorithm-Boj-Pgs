select NAME,count(name) as COUNT
from ANIMAL_INS 
where name is not null
group by name
having count(name) >1
order by name