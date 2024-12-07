SELECT
    f.user_id,
    COUNT(*) AS followers_count
FROM 
    Followers f
GROUP BY 
    f.user_id
ORDER BY 
    user_id
;