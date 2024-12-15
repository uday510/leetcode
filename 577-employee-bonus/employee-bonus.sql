SELECT 
    e1.name, b.bonus
FROM
    Employee e1 
LEFT JOIN 
    Bonus b
ON
    e1.empId = b.empId
WHERE
    b.empId is NULL OR b.bonus < 1000
;