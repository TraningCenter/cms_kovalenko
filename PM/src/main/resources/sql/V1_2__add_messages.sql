CREATE SEQUENCE messages_id_seq;

CREATE TABLE messages (
  message_id    INTEGER NOT NULL DEFAULT nextval('messages_id_seq'),
  user_id INTEGER NOT NULL,
  post_id INTEGER NOT NULL,
  date_time TIMESTAMP DEFAULT NOW(),
  text VARCHAR NOT NULL,
  CONSTRAINT message_id_pk PRIMARY KEY (message_id)
);

ALTER SEQUENCE messages_id_seq
OWNED BY messages.message_id;

ALTER TABLE messages ADD CONSTRAINT post_message_fk
FOREIGN KEY (post_id)
REFERENCES posts (post_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE messages ADD CONSTRAINT user_message_fk
FOREIGN KEY (user_id)
REFERENCES users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
