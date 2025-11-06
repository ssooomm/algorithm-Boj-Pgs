SELECT
    H.HOUR,
    COUNT(A.DATETIME) AS COUNT
FROM
    (
        -- 0부터 23까지의 시간(HOUR)을 생성합니다.
        SELECT LEVEL - 1 AS HOUR
        FROM DUAL
        CONNECT BY LEVEL <= 24
    ) H
LEFT JOIN
    ANIMAL_OUTS A
    -- 생성된 시간(HOUR)과 ANIMAL_OUTS 테이블의 DATETIME의 시간 부분을 조인합니다.
    ON H.HOUR = TO_CHAR(A.DATETIME, 'HH24')
GROUP BY
    H.HOUR
ORDER BY
    H.HOUR;