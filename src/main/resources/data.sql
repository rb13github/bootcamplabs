DROP TABLE IF EXISTS user;
CREATE TABLE user(id NUMBER AUTO_INCREMENT PRIMARY KEY,name VARCHAR(15) NOT NULL,password VARCHAR(100) NOT NULL);
INSERT INTO user(name,password ) VALUES ('user1', '$2a$10$7bvyCx6OGn7rQnwgVnvbDOWagw5s3T.oslj5VYvyJWQcPvnBZ8uFa' ), ('user2', '$2a$10$E4FZjdsa8ohDmh6v6wwLlOd5dPbpPHhGCR7RrMdTXCHg2s2ZGcD4e' ),('user3','$2a$10$6ULHPNijESBKLBgjogwWt.rnu4By3nWrnSThnWqwMunQkzuVCds3m');