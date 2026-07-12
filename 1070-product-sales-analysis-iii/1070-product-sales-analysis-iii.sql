# Write your MySQL query statement below

select s.product_id, s.year as first_year, s.quantity, s.price from sales s join sales s2 on s.product_id = s2.product_id
group by s.sale_id
having first_year = min(s2.year)


