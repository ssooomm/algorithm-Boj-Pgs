select ANIMAL_ID,NAME
from ANIMAL_INS
where ANIMAL_TYPE = 'Dog'
and upper(name) like '%EL%'
order by name