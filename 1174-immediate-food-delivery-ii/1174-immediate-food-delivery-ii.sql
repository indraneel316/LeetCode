SELECT ROUND(
    SUM(CASE WHEN d.order_date = d.customer_pref_delivery_date THEN 1 ELSE 0 END) 
    / COUNT(d.customer_id) * 100, 
    2
) AS immediate_percentage
FROM Delivery d
LEFT JOIN Delivery d2 
    ON d.customer_id = d2.customer_id 
   AND d2.order_date < d.order_date
WHERE d2.customer_id IS NULL;