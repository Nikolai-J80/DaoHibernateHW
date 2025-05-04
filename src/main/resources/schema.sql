create table city
(
    id   INT,
    name varchar(100),
    PRIMARY KEY (id)
);

insert into city(id, name)
values (1, 'Москва'),
       (2, 'Санкт-Петербург'),
       (3, 'Казань');


create table person
(
    name           varchar(200),
    surname        varchar(200),
    age            INT,
    phone_number   varchar(100),
    city_of_living_id int,
    PRIMARY KEY (name, surname, age)
);

insert into person(name, surname, age, city_of_living_id, phone_number)
values ('Иван', 'Иванов', 25, 1, '+7(800)555-35-35'),
       ('Петр', 'Петров', 18, 2, '+7(905)555-46-64'),
       ('Борис', 'Борисов', 23, 1, '+7(900)700-20-20'),
       ('Николай', 'Иванов', 45, 3, '+7(960)000-44-33'),
       ('Ольга', 'Сидорова', 30, 3, '+7(912)555-44-33');
