CREATE TABLE employee
(
    employee_id INT AUTO_INCREMENT,
    first_name Varchar(30)NOT NULL,
    last_name Varchar(30) NOT NULL,
    phone Varchar(13) NOT NULL UNIQUE,
    primary key(employee_id)
);

INSERT INTO employee
(first_name, last_name, phone )
VALUES
    ('Всеволод', 'Броварчук', '+380683670599'),
    ('Тарас', 'Мельниченко', '+380935111904'),
    ('Галина ', 'Іванченко', '+380949187130'),
    ('Валерія', 'Броварчук', '+380944191532'),
    ('Микита', 'Середа', '+380993962165'),
    ('Борис', 'Васильчук', '+380935519841'),
    ('Олена', 'Шевченко', '+380639189837'),
    ('Віктор', 'Васильєв', '+380959679803'),
    ('Станіслав', 'Таращук', '+380972535858'),
    ('Діана', 'Антоненко', '+380961871748');