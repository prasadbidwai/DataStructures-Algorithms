
/* 1. find top 3 salaries per department
Employee table:
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
+----+-------+--------+--------------+

Department table: 
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+

Result should be like : 
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Randy    | 85000  |
| IT         | Joe      | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+
*/

Select dep.Name as Department
,emp.Name as Employee
,emp.Salary 
from 
    Department dep, 
    Employee emp 
where  
    emp.DepartmentId=dep.Id 
and  
(Select count(distinct Salary) From Employee where DepartmentId=dep.Id and Salary>emp.Salary)<3;


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

Expected Output:
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+

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
    f.DepartmentId = d.id;

/*
3. Nth Highest Salary:

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
*/


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set N= N-1;
  RETURN (
      # Write your MySQL query statement below.
   
      select distinct Salary from Employee order by Salary desc limit N,1
  );
END

/*
4. Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
*/

select distinct l1.Num from Logs l1, Logs l2, Logs l3
where l1.Id = l2.id-1 and l2.Id = l3.Id-1
and l1.Num = l2.Num and l2.Num = l3.Num;


/*
5. The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+*/

select a.Name as Employee
from Employee a, Employee b
where a.ManagerId = b.Id and a.Salary > b.salary;

/*
6. Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.

*/

delete p1
from
Person p1, Person p2
where 
p1.Id > p2.Id and
p1.Email = p2.Email;


/*
7. Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+

Answer should be like:

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
*/

SELECT
  Score,
  (SELECT count(distinct Score) FROM Scores WHERE Score >= s.Score) Rank
FROM Scores s
ORDER BY Score desc;
