select ANIMAL_TYPE,coalesce(NAME,'No name'),SEX_UPON_INTAKE
from ANIMAL_INS 
order by ANIMAL_ID