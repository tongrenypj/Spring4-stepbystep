CREATE TABLE IF NOT EXISTS t_user (
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  age int,
  create_time TIMESTAMP
);

insert into t_user(name,age,create_time)values('Tom',20,now()),('Zhang',21,now()),('Li',22,now());