INSERT INTO Login (id, email, password)
VALUES (100, 'admin@hrapp.com',
        '$2a$10$.SyUI676n6JqmougPFYtIOeC3c4gjCKsCVrtGKipGkzoMwZvwLxD.'); -- admin

INSERT INTO Person (id, first_name, last_name, birthdate)
VALUES (100, 'John', 'Smith', '1972-01-21');

INSERT INTO Admin (id, login_id)
VALUES (100, 100);