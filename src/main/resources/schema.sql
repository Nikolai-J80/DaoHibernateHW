create table person ( name varchar(200),
                      surname varchar(200),
                      age INT,
                      phone_number varchar(100),
                      city_of_living varchar(100),
                      PRIMARY KEY(name, surname ,age)
);

    insert into person(name, surname, age, city_of_living, phone_number)
    values ('Иван', 'Иванов', 25, 'Москва', '+7(800)555-35-35'),
    ('Петр', 'Петров', 18, 'Санкт-Петербург', '+7(905)555-46-64'),
    ('Борис', 'Борисов', 23,'Москва','+7(900)700-20-20'),
    ('Николай', 'Иванов', 45,'Казань','+7(960)000-44-33'),
    ('Ольга', 'Сидорова', 30,'Казань', '+7(912)555-44-33');
