INSERT INTO role (description, role) VALUES ('Default user role', 'USER');

INSERT INTO user (email, first_name, last_name, login, password) VALUES ('marktwain@gmail.com', 'Mark', 'Twain', 'Marko', 'secret');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);