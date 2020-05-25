CREATE TABLE Admin
(
    id       int NOT NULL UNIQUE,
    login_id int NOT NULL UNIQUE,
    PRIMARY KEY (id),
    CONSTRAINT FK_Admin_Person FOREIGN KEY (id) REFERENCES Person (id),
    CONSTRAINT FK_Admin_Login FOREIGN KEY (login_id) REFERENCES Login (id)
);
