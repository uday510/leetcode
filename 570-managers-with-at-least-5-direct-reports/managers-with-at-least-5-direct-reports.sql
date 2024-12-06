# Write your MySQL query statement below

SELECT 
    name
FROM 
    Employee e1
JOIN (
    SELECT 
        managerId
    FROM
        Employee 
    GROUP BY managerId
    HAVING COUNT(managerId) >= 5) e2
ON e1.id = e2.managerId