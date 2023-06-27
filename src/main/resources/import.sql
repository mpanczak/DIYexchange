INSERT INTO users (id, email, login, password) VALUES (1, 'johndoe@gmail.com', 'johndoe', '$2a$10$b5qjI/WewW1JLZEPEqzx5uYkQRz7tMuVmkQzyOVenYO57nQk.Me1m'); # secret
INSERT INTO users (id, email, login, password) VALUES (2, 'mpanczak@gmail.com', 'mpanczak', '$2a$10$Dd3N5h3l4L9Afs9BOlPZweJplotTwc5VMUWUis1rJvfEJpKEOFcX.'); # changeit
INSERT INTO users (id, email, login, password) VALUES (3, 'tommy@gmail.com', 'tommy', '$2a$10$Dd3N5h3l4L9Afs9BOlPZweJplotTwc5VMUWUis1rJvfEJpKEOFcX.'); # changeit
INSERT INTO users (id, email, login, password) VALUES (4, 'luke@o2.com', 'luke', '$2a$10$Dd3N5h3l4L9Afs9BOlPZweJplotTwc5VMUWUis1rJvfEJpKEOFcX.'); # changeit
INSERT INTO users (id, email, login, password) VALUES (5, 'jack@yahoo.com', 'jack', '$2a$10$Dd3N5h3l4L9Afs9BOlPZweJplotTwc5VMUWUis1rJvfEJpKEOFcX.'); # changeit

INSERT INTO posts (id, user_id, content) VALUES (1, 1, 'Dzięki uprzejmości firmy Botland otrzymałem solidny rabat na płytki wyposażone w najnowsze układy NVIDIA Jetson Orin, więc w niniejszym worklogu postaram się podzielić wrażeniami z poznawania ich możliwości. Głównymi bohaterami tego wpisu są dwie poniższe płytki (ceny z czerwca 2023)');

INSERT INTO comments (id, post_id, timestamp, user_id, content) VALUES (1, 1, CURRENT_TIMESTAMP, 1, 'Super projekt!');
# INSERT INTO comments (id, post_id, timestamp, user_id, content) VALUES (1, 2, '1687796312', 2, 'Super projekt!');

INSERT INTO reactions (id, post_id, user_id) VALUES (1, 1, 2);


INSERT INTO follows (id, user_id) VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5);#, (6, 1);
# INSERT INTO follows_watchlist (watchlist_id, follow_id) VALUES (2, 1), (2, 3), (2, 5);
# INSERT INTO follows_watchlist (watchlist_id, follow_id) VALUES (5, 4), (5, 1), (5, 3);

INSERT INTO follows_users (follow_id, users_id) VALUES (2, 1), (2, 3), (2, 5);
INSERT INTO follows_users (follow_id, users_id)  VALUES (5, 4), (5, 1), (5, 3);


SELECT LOAD_FILE('/tmp/diybuddy.jpg')


# INSERT INTO follows (user_id) VALUES (1), (2), (3), (5);
# INSERT INTO follows_watchlist (follow_user_id, watchlist_id) VALUES (2, 1), (2, 3), (2, 5);
# INSERT INTO follows_watchlist (follow_user_id, watchlist_id) VALUES (5, 4), (5, 1), (5, 3);

