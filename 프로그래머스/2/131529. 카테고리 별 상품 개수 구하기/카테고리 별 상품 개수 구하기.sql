select substr(PRODUCT_CODE,1,2) AS category,COUNT(PRODUCT_CODE) AS PRODUCTS
from PRODUCT 
group by substr(PRODUCT_CODE,1,2)
order by category