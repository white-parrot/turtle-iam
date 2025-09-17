create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

-- Insert user
INSERT INTO users (username, password, enabled) VALUES ('admin', '{bcrypt}$2a$12$z41u6Xh0kiLi3EZAUje2feUnSGMefHvXF0q58Uo5FmfzvllILT8.m', true);
INSERT INTO users (username, password, enabled) VALUES ('user', '{noop}userPasswd', true);

-- Insert authorities for that user
INSERT INTO authorities (username, authority) VALUES ('admin', 'READ');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ADMIN');