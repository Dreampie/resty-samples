DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id           BIGINT       NOT NULL AUTO_INCREMENT,
  username     VARCHAR(50)  NOT NULL
  COMMENT '登录名',
  email        VARCHAR(200) COMMENT '邮箱',
  phone        VARCHAR(50) COMMENT '联系电话',
  password     VARCHAR(200) NOT NULL
  COMMENT '密码',
  avatar_url   VARCHAR(255) COMMENT '头像',
  first_name   VARCHAR(10) COMMENT '名字',
  last_name    VARCHAR(10) COMMENT '姓氏',
  full_name    VARCHAR(20) COMMENT '全名',
  created_at   DATETIME     NOT NULL,
  updated_at   DATETIME     NULL,
  deleted_at   DATETIME     NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '用户';
