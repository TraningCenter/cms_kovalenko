CREATE SEQUENCE users_id_seq;

CREATE TABLE users (
  user_id    INTEGER NOT NULL DEFAULT nextval('users_id_seq'),
  first_name VARCHAR,
  last_name  VARCHAR,
  username   VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  CONSTRAINT user_id_pk PRIMARY KEY (user_id)
);

ALTER SEQUENCE users_id_seq
OWNED BY users.user_id;

CREATE SEQUENCE posts_id_seq;

CREATE TABLE posts (
  post_id    INTEGER NOT NULL DEFAULT nextval('posts_id_seq'),
  title      VARCHAR NOT NULL,
  user_id    INTEGER NOT NULL,
  text_id    INTEGER,
  pictures_id VARCHAR,
  date_time TIMESTAMP DEFAULT NOW(),
  CONSTRAINT post_pk PRIMARY KEY (post_id)
);

ALTER SEQUENCE posts_id_seq
OWNED BY posts.post_id;

ALTER TABLE posts
  ADD CONSTRAINT user_post_fk
FOREIGN KEY (user_id)
REFERENCES users (user_id)
ON DELETE RESTRICT
ON UPDATE RESTRICT
  NOT DEFERRABLE;

ALTER TABLE users ADD UNIQUE (username);