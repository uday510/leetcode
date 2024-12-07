SELECT 
    A1.player_id,
    A1.event_date,
    (
        SELECT 
            SUM(games_played)
        FROM
            Activity A2
        WHERE 
            A1.player_id = A2.player_id
            AND A2.event_date <= A1.event_date
    ) AS games_played_so_far
FROM
    Activity A1;