INSERT INTO users (first_name, last_name, username, password)
  VALUES ('Nataliia','Kovalenko','HeyTricky','12345');

INSERT INTO users (first_name, last_name, username, password)
  VALUES ('Marina','Koricheva','MariKa','12345');

INSERT INTO posts (title, user_id, text_id, pictures_id)
  VALUES ('Samsung случайно сделал из сотрудников мультимиллионеров', 1, 1, '2, 3');

INSERT INTO posts (title, user_id, text_id, pictures_id)
  VALUES ('Skyrim VR помогла игроку сбросить 4,5 килограмма за полторы недели', 1, 4, '5, 6');

INSERT INTO posts (title, user_id, text_id, pictures_id)
  VALUES ('Имитация голоса уже реальность', 2, 7, '8');

INSERT INTO messages (user_id, post_id, text)
  VALUES (2, 1, 'Повезло им!');

