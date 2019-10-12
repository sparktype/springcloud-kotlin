CREATE TABLE user
(
  id       bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  user_id  varchar(50),
  name     varchar(20),
  password varchar(20),
  PRIMARY KEY (id)
);