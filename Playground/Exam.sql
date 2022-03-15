SELECT DeptCode, WorkStatus, TotalEmp, Count(Dp.TotalEmp)
FROM Department as Dp, Employee as Emp
WHERE Dp.TotalEmp BETWEEN 2 AND 4
GROUP BY Dp.DeptCode, Emp.WorkStatus;


SELECT DeptCode, WorkStatus, TotalEmp, Count(Dp.TotalEmp), AVG(Salary)
FROM Department as Dp, Employee as Emp
WHERE (WorkStatus = 'W' AND Emp.Salary > AVG(E.Salary))
ORDER BY Dp.DeptCode DESC;


