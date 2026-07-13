# Write your MySQL query statement below
with total_players as (
    select count(distinct player_id) as n
    from activity
),
 first_login as (
    select player_id, min(event_date) as event_date
    from activity
    group by player_id
) 

select round(count(distinct a.player_id)/(select n from total_players),2) as fraction
from activity a 
join first_login f on a.player_id= f.player_id and datediff(a.event_date, f.event_date) = 1
