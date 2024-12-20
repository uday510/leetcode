SELECT 
    p.product_name, s.year, s.price AS price
FROM
    Sales s
JOIN 
    Product p 
ON 
    s.product_id = p.product_id