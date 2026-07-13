# Write your MySQL query statement below
with nums as (
    select num as cnt1 from MyNumbers
    group by num
    having count(num)=1
)

select max(cnt1) as num from nums