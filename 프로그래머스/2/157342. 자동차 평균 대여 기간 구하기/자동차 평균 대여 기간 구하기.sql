SELECT   car_id
       , TO_CHAR(ROUND(AVG(end_date - start_date + 1), 1), 'FM9999.0') AS average_duration
      -- 소수점 이하 1자리값이 없다면 0으로 고정
FROM     car_rental_company_rental_history
GROUP BY car_id
HAVING   AVG(end_date - start_date + 1) >= 7
      -- 대여 시작일부터 1일이기에 '+1'을 해야 해
ORDER BY TO_NUMBER(average_duration) DESC
      -- 평균 대여 기간에 TO_CHAR를 사용했더니 문자열로 바껴서 정렬에 문제가 생겨서 숫자형식으로 다시 바꿈
       , car_id DESC;