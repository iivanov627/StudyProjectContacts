INSERT INTO contacts (telephone, first_name, last_name, email)
VALUES
('+7(999) 000-11-11', 'Ivan', 'Petrov', 'ivan.petrov@mail.com'),
('+79990002222', 'Alex', 'Sidorov', 'alex.sidorov@mail.com'),
('+79990003333', 'Maria', 'Smirnova', 'maria.smirnova@mail.com'),
('+79990004444', 'Dmitry', 'Kuznetsov', 'dmitry.kuznetsov@mail.com'),
('+79990005555', 'Olga', 'Ivanova', 'olga.ivanova@mail.com');


INSERT INTO Contact_owners (id, username, description, email, password, role)
VALUES
('85a222f7-ce0c-4fb8-ae79-44b0443ed8e4', 'sergey', 'main owner account', 'sergey@mail.com', '123456', 'USER'),
('c1b5b8f3-9c3a-4bde-8f45-2f7f1a8d9c11', 'alex', 'second owner', 'alex@mail.com', '123456', 'ADMIN'),
('f2d9c8a1-3b7e-4c11-9a5d-111111111111', 'ivan', 'test owner', 'ivan@mail.com', '123456', 'USER'),
('a9c2d1e4-5f67-4a88-9c12-222222222222', 'maria', 'marketing owner', 'maria@mail.com', '123456', 'USER'),
('b8e3f9d2-7c11-4d55-8a33-333333333333', 'dmitry', 'system owner', 'dmitry@mail.com', '123456', 'ADMIN');