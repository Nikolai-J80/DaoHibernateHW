SELECT p.name,p.surname,p.age
FROM person p
        RIGHT JOIN city c ON p.city_of_living_id = c.id
WHERE c.name = :city