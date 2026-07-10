# Write your MySQL query statement belo
select customer_id, count(*) as count_no_trans
from visits left join transactions  on visits.visit_id = transactions.visit_id 
where transactions.visit_id is NULL
group by customer_id