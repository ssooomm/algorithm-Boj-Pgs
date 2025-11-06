WITH VALUE AS (
    SELECT
        car.daily_fee,
        car.car_type,
        his.history_id,
        -- Oracle: 날짜 뺄셈으로 일 수 차이 계산 (end_date - start_date) + 1
        (his.end_date - his.start_date) + 1 AS period,
        CASE
            -- Oracle에서도 CASE WHEN 구문은 동일하게 사용됩니다.
            WHEN (his.end_date - his.start_date) + 1 >= 90 THEN '90일 이상'
            WHEN (his.end_date - his.start_date) + 1 >= 30 THEN '30일 이상'
            WHEN (his.end_date - his.start_date) + 1 >= 7  THEN '7일 이상'
            ELSE 'NONE'
        END AS duration_type
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY his
    INNER JOIN
        CAR_RENTAL_COMPANY_CAR car ON car.car_id = his.car_id
    WHERE
        car.car_type = '트럭'
)
SELECT
    v.history_id,
    -- Oracle: IFNULL 대신 NVL 사용
    ROUND(v.daily_fee * v.period *
          (100 - NVL(plan.discount_rate, 0)) / 100) AS fee
FROM
    VALUE v
LEFT JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN plan
    ON plan.duration_type = v.duration_type
    AND plan.car_type = v.car_type
ORDER BY
    fee DESC,
    v.history_id DESC;