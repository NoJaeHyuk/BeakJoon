-- 코드를 입력하세요
-- select max(FAVORITES) as 'max_FAVORITES',FOOD_TYPE
	-- from rest_info
	-- group by FOOD_TYPE

SELECT 
a.FOOD_TYPE,
REST_ID,
REST_NAME,
FAVORITES
from rest_info a
join (
	select max(FAVORITES) as 'max_FAVORITES',FOOD_TYPE
	from rest_info
	group by FOOD_TYPE
) c 
ON a.FAVORITES = c.max_FAVORITES 
AND a.FOOD_TYPE = c.FOOD_TYPE
ORDER BY FOOD_TYPE DESC;

