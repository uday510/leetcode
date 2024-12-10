SELECT 
    s.student_id, s.student_name, 
    sub.subject_name,
    IFNULL(grouped.attended_exams, 0) AS attended_exams
FROM 
    Students s
CROSS JOIN
    Subjects sub
LEFT JOIN (
    SELECT
        e.student_id, e.subject_name,
        COUNT(*) AS attended_exams
    FROM
        Examinations e
    GROUP BY 
        e.student_id, e.subject_name
) AS grouped
ON
    s.student_id = grouped.student_id AND sub.subject_name = grouped.subject_name
ORDER BY 
    s.student_id, sub.subject_name
;