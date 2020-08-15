CREATE TABLE reviews (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       comment VARCHAR(256) NOT NULL,
                       image VARCHAR(256),
                       stars VARCHAR(256),
                       date DATE NOT NULL,
                       user_id BIGINT NOT NULL,
                       place_id BIGINT NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (place_id) REFERENCES `places` (`id`),
                       FOREIGN KEY (user_id) REFERENCES `users` (`id`)

);