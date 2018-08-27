
CREATE TABLE EMPLOYEE(
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
    joining_date DATETIME NOT NULL,
    salary DOUBLE NOT NULL,
--    ssn VARCHAR(30) NOT NULL UNIQUE,
  	ssn VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);
