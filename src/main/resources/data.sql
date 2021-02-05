DROP TABLE IF EXISTS user;
CREATE TABLE user(id NUMBER AUTO_INCREMENT PRIMARY KEY,name VARCHAR(15) NOT NULL,password VARCHAR(100) NOT NULL);
INSERT INTO user(name,password ) VALUES ('user1', 'pass' ), ('user2', 'pass' ),('user3','pass');