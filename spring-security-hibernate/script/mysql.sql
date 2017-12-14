create database securityTest;
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP,ALTER,INDEX on securityTest.* TO 'root'@'localhost' IDENTIFIED BY 'root';
-- to consult grant
-- SHOW GRANTS FOR root@localhost;


CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username)
  );

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
  );

INSERT INTO users(username,password,enabled) VALUES ('cylixx','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);
INSERT INTO users(username,password,enabled) VALUES ('alex','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);

INSERT INTO user_roles (username, role) VALUES ('cylixx', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('cylixx', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('alex', 'ROLE_USER');
