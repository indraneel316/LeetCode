# Write your MySQL query statement below

select name, bonus from employee left join
 Bonus on employee.empId = bonus.empId
 where Bonus.empId is NULL OR bonus<1000
