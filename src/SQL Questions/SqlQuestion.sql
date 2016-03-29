
-- 1. find top 3 salaries per department

Select dep.Name as Department
,emp.Name as Employee
,emp.Salary 
from 
    Department dep, 
    Employee emp 
where  
    emp.DepartmentId=dep.Id 
and  
(Select count(distinct Salary) From Employee where DepartmentId=dep.Id and Salary>emp.Salary)<3


-- 2. Department wise highest salary 

/*
Employee table: 
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+

Department Table: 
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+

*/
select distinct(d.Name) as Department, f.name as Employee, r.maxsalary as Salary 
from
(select 
    e.DepartmentId, max(e.salary)as maxsalary
from 
    Employee e
group by 1)r, Employee f, Department d  
where 
    r.maxsalary = f.salary
and 
    r.DepartmentId = f.DepartmentId 
and 
    f.DepartmentId = d.id 