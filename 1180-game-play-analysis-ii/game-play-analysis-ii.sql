SELECT 
    DISTINCT A.player_id,
    FIRST_VALUE(A.device_id) OVER (
        PARTITION BY 
            A.player_id
        ORDER BY
            A.event_date
    ) device_id
FROM
    Activity A;