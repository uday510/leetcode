SELECT 
    ROUND(
        (SUM(CASE 
            WHEN order_date = customer_pref_delivery_date THEN 1 
            ELSE 0 
        END) / COUNT(*)) * 100, 2
    ) AS immediate_percentage
FROM (
    SELECT 
        delivery_id,
        customer_id,
        order_date,
        customer_pref_delivery_date
    FROM 
        Delivery d
    WHERE 
        order_date = (
            SELECT MIN(order_date)
            FROM Delivery
            WHERE customer_id = d.customer_id
        )
) AS first_orders;
