WITH CAR_FEES AS (
    SELECT
        C.CAR_ID,
        C.CAR_TYPE,
        -- 대여료 x 30일 x 내야할 비율 = 요금 계산
        -- P.DISCOUNT_RATE가 NULL일 가능성은 없다고 가정 (할인 계획 테이블이므로)
        ROUND(C.DAILY_FEE * 30 * (100 - P.DISCOUNT_RATE) / 100) AS FEE,
        P.DURATION_TYPE
    FROM
        CAR_RENTAL_COMPANY_CAR C
    JOIN
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON C.CAR_TYPE = P.CAR_TYPE
    WHERE
        -- 대여 기간이 '30일 이상'인 할인 계획만 선택
        P.DURATION_TYPE LIKE '30일 이상'
        -- 자동차 종류가 세단 또는 SUV인 것만 선택
        AND C.CAR_TYPE IN ('세단', 'SUV')
)
-- ---
SELECT
    CF.CAR_ID,
    CF.CAR_TYPE,
    CF.FEE
FROM
    CAR_FEES CF
WHERE
    -- 30일간의 대여 금액 조건 적용
    CF.FEE >= 500000 AND CF.FEE < 2000000
    -- 2022-11-01부터 2022-12-01까지 대여 기록이 없는 CAR_ID를 필터링 (NOT IN 사용)
    AND CF.CAR_ID NOT IN (
        SELECT
            CAR_ID
        FROM
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE
            -- Oracle은 TO_DATE 함수를 사용하여 문자열을 명시적으로 DATE 타입으로 변환 권장
            END_DATE >= TO_DATE('2022-11-01', 'YYYY-MM-DD')
            AND START_DATE <= TO_DATE('2022-12-01', 'YYYY-MM-DD')
    )
ORDER BY
    CF.FEE DESC,
    CF.CAR_TYPE ASC, -- 원본 쿼리의 ORDER BY에는 CAR_TYPE이 있었으나, GROUP BY에는 없었으므로 여기서는 포함했습니다.
    CF.CAR_ID DESC;