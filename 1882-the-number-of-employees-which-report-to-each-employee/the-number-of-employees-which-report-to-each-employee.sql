SELECT 
    m.employee_id,
    m.name,
    COUNT(emp.employee_id) AS reports_count,
    ROUND(
        AVG(emp.age)
    ) AS average_age
    FROM 
        employees emp
        JOIN
             employees m ON emp.reports_to = m.employee_id
    GROUP BY 
        m.employee_id
    ORDER BY 
        m.employee_id
