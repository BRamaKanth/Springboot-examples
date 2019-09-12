INSERT INTO employee (empId,name,hireDate,salary) 
SELECT * FROM ( SELECT 'EM001','PAVAN',TO_DATE('2015-11-13', 'yyyy-MM-DD'),45000) as tmp
WHERE NOT EXISTS (
   SELECT empId from employee WHERE empId='EM001'
) LIMIT 1;

INSERT INTO employee (empId,name,hireDate,salary) 
SELECT * FROM ( SELECT 'EM002','SAPNA',TO_DATE('2015-02-11', 'yyyy-MM-DD'),55000) as tmp
WHERE NOT EXISTS (
   SELECT empId from employee WHERE empId='EM002'
) LIMIT 1;

INSERT INTO employee (empId,name,hireDate,salary) 
SELECT * FROM ( SELECT 'EM003','VIJAY',TO_DATE('2017-12-25', 'yyyy-MM-DD'),35000) as tmp
WHERE NOT EXISTS (
   SELECT empId from employee WHERE empId='EM003'
) LIMIT 1;

INSERT INTO employee (empId,name,hireDate,salary)
SELECT * FROM ( SELECT 'EM004','SANJAY',TO_DATE('2017-05-08', 'yyyy-MM-DD'),45000) as tmp
WHERE NOT EXISTS (
   SELECT empId from employee WHERE empId='EM004'
) LIMIT 1;

INSERT INTO employee (empId,name,hireDate,salary) 
SELECT * FROM ( SELECT 'EM005','RAMAKANTH',TO_DATE('2015-04-13', 'yyyy-MM-DD'),85000) as tmp
WHERE NOT EXISTS (
   SELECT empId from employee WHERE empId='EM005'
) LIMIT 1;

INSERT INTO employee (empId,name,hireDate,salary) 
SELECT * FROM ( SELECT 'EM006','HEMA',TO_DATE('2013-06-13', 'yyyy-MM-DD'),65000) as tmp
WHERE NOT EXISTS (
   SELECT empId from employee WHERE empId='EM006'
) LIMIT 1;

INSERT INTO employee (empId,name,hireDate,salary)
SELECT * FROM ( SELECT  'EM007','SILPA',TO_DATE('2014-11-23', 'yyyy-MM-DD'),95000) as tmp
WHERE NOT EXISTS (
   SELECT empId from employee WHERE empId='EM007'
) LIMIT 1;