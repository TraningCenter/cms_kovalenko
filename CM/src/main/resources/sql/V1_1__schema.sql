CREATE SEQUENCE contents_id_seq;


CREATE TABLE contents (
  content_id INTEGER NOT NULL DEFAULT nextval('contents_id_seq'),
  content VARCHAR NOT NULL,
  post_id INTEGER NOT NULL,
  CONSTRAINT content_id_pk PRIMARY KEY (content_id)
);

ALTER SEQUENCE contents_id_seq
OWNED BY contents.content_id;
