INSERT INTO users (id, email, login, password) VALUES (1, 'johndoe@gmail.com', 'johndoe', '$2a$10$b5qjI/WewW1JLZEPEqzx5uYkQRz7tMuVmkQzyOVenYO57nQk.Me1m'); # secret
INSERT INTO users (id, email, login, password) VALUES (2, 'mpanczak@gmail.com', 'mpanczak', '$2a$10$Dd3N5h3l4L9Afs9BOlPZweJplotTwc5VMUWUis1rJvfEJpKEOFcX.'); # changeit
INSERT INTO users (id, email, login, password) VALUES (3, 'tommy@gmail.com', 'tommy', '$2a$10$Dd3N5h3l4L9Afs9BOlPZweJplotTwc5VMUWUis1rJvfEJpKEOFcX.'); # changeit
INSERT INTO users (id, email, login, password) VALUES (4, 'luke@o2.com', 'luke', '$2a$10$Dd3N5h3l4L9Afs9BOlPZweJplotTwc5VMUWUis1rJvfEJpKEOFcX.'); # changeit
INSERT INTO users (id, email, login, password) VALUES (5, 'jack@yahoo.com', 'jack', '$2a$10$Dd3N5h3l4L9Afs9BOlPZweJplotTwc5VMUWUis1rJvfEJpKEOFcX.'); # changeit

INSERT INTO roles (id, name) VALUES (1, 'user'), (2, 'admin');

INSERT INTO roles_users (roles_id, users_id) VALUES (1, 1), (1, 2), (1, 3), (2, 1);

INSERT INTO posts (id, user_id, content) VALUES (1, 1, 'Dzięki uprzejmości firmy Botland otrzymałem solidny rabat na płytki wyposażone w najnowsze układy NVIDIA Jetson Orin, więc w niniejszym worklogu postaram się podzielić wrażeniami z poznawania ich możliwości. Głównymi bohaterami tego wpisu są dwie poniższe płytki (ceny z czerwca 2023)');

INSERT INTO comments (id, post_id, timestamp, user_id, content) VALUES (1, 1, CURRENT_TIMESTAMP, 1, 'Super projekt!');

INSERT INTO posts_liked_by_users (liked_by_users_id, liked_posts_id) VALUES (2, 1);

INSERT INTO user_follows (followed_id, follower_id) VALUES (2, 1), (2, 3), (2, 5);
INSERT INTO user_follows (followed_id, follower_id) VALUES (5, 4), (5, 1), (5, 3);


SELECT LOAD_FILE('/tmp/diybuddy.jpg')

