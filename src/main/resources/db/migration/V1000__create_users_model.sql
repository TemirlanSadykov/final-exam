CREATE TABLE users (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       login VARCHAR(256) NOT NULL,
                       email VARCHAR(256) NOT NULL,
                       password VARCHAR(256) NOT NULL,
                       enabled boolean NOT NULL default true,
                       role VARCHAR(32) NOT NULL default 'USER',
                       PRIMARY KEY (id)
);