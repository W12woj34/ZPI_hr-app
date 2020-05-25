CREATE TABLE Login
(
    id       int          NOT NULL AUTO_INCREMENT,
    email    varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Person
(
    id         int          NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name  varchar(255) NOT NULL,
    birthdate  date,
    version    int          NOT NULL DEFAULT (0),
    PRIMARY KEY (id)
);

CREATE TABLE HR_Worker
(
    id       int NOT NULL,
    login_id int NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FKHRWorker58293 FOREIGN KEY (id) REFERENCES Person (id),
    CONSTRAINT FK_HRWorker_Login FOREIGN KEY (login_id) REFERENCES Login (id)
);

CREATE TABLE Employee
(
    id       int NOT NULL,
    login_id int NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FKEmployee729552 FOREIGN KEY (id) REFERENCES Person (id),
    CONSTRAINT FK_Employee_Login FOREIGN KEY (login_id) REFERENCES Login (id)
);

CREATE TABLE Terminated_Employee
(
    id                int NOT NULL,
    availability      varchar(255),
    next_date_contact date,
    PRIMARY KEY (id),
    CONSTRAINT FKTerminated605355 FOREIGN KEY (id) REFERENCES Employee (id)
);

CREATE TABLE Working_Employee
(
    id int NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FKWorkingEmp371545 FOREIGN KEY (id) REFERENCES Employee (id)
);

CREATE TABLE Applicant
(
    id                 int NOT NULL,
    position           varchar(255),
    initial_assessment int,
    comments           varchar(2000),
    scheduled_meeting  datetime,
    PRIMARY KEY (id),
    CONSTRAINT FK_Applicant_Person FOREIGN KEY (id) REFERENCES Person (id)
);

CREATE TABLE Contact
(
    id       int NOT NULL,
    mobile   varchar(255),
    email    varchar(255),
    git      varchar(255),
    linkedin varchar(255),
    other    varchar(1024),
    version  int NOT NULL DEFAULT (0),
    PRIMARY KEY (id),
    CONSTRAINT FKContact419042 FOREIGN KEY (id) REFERENCES Employee (id)
);

CREATE TABLE Education
(
    id               int          NOT NULL AUTO_INCREMENT,
    employee_id      int          NOT NULL,
    institution      varchar(255) NOT NULL,
    field_of_study   varchar(255) NOT NULL,
    education_period varchar(255) NOT NULL,
    degree           varchar(255) NOT NULL,
    version          int          NOT NULL DEFAULT (0),
    PRIMARY KEY (id),
    CONSTRAINT FKEducation90263 FOREIGN KEY (employee_id) REFERENCES Employee (id)
);

CREATE TABLE Experience
(
    id             int          NOT NULL AUTO_INCREMENT,
    employee_id    int          NOT NULL,
    company_name   varchar(255) NOT NULL,
    position       varchar(255) NOT NULL,
    working_period varchar(255) NOT NULL,
    version        int          NOT NULL DEFAULT (0),
    PRIMARY KEY (id),
    CONSTRAINT FKExperience950234 FOREIGN KEY (employee_id) REFERENCES Employee (id)
);

CREATE TABLE Skill_Category
(
    id   int          NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE Skill
(
    id             int          NOT NULL AUTO_INCREMENT,
    name           varchar(255) NOT NULL UNIQUE,
    skill_category int          NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FKSkill822377 FOREIGN KEY (skill_category) REFERENCES Skill_Category (id)
);

CREATE TABLE Skill_Level
(
    id          int NOT NULL AUTO_INCREMENT,
    employee_id int NOT NULL,
    skill_id    int NOT NULL,
    level       int,
    PRIMARY KEY (id),
    CONSTRAINT unique_pair_employee_skill
        UNIQUE (employee_id, skill_id),
    CONSTRAINT FKSkillLevel259260 FOREIGN KEY (employee_id) REFERENCES Employee (id),
    CONSTRAINT FKSkillLevel452942 FOREIGN KEY (skill_id) REFERENCES Skill (id)
);

CREATE TABLE Language
(
    id   int          NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Language_Level
(
    id    int          NOT NULL AUTO_INCREMENT,
    level varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE Language_Knowledge
(
    id          int NOT NULL AUTO_INCREMENT,
    employee_id int NOT NULL,
    language_id int NOT NULL,
    level_id    int NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT unique_pair_employee_language
        UNIQUE (language_id, employee_id),
    CONSTRAINT FKLanguageKn538830 FOREIGN KEY (employee_id) REFERENCES Employee (id),
    CONSTRAINT FKLanguageKn510132 FOREIGN KEY (language_id) REFERENCES Language (id),
    CONSTRAINT FKLanguageKn613256 FOREIGN KEY (level_id) REFERENCES Language_Level (id)
);

