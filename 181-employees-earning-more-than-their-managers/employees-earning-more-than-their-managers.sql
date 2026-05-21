# Write your MySQL query statement below
select e.name as Employee from Employee e
where e.managerId >=0 and e.salary > (
    select a.salary from Employee a where e.managerId = a.id
)