CREATE TABLE IF NOT EXISTS  Employee (
    empId   VARCHAR(128) NOT NULL ,
    name VARCHAR(128) NOT NULL,
    hireDate DATE NOT NULL,
    salary DOUBLE,
    PRIMARY KEY (empId)
);