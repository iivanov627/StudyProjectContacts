INSERT INTO contact_owners (id, username, description, email, password, role) VALUES
('550e8400-e29b-41d4-a716-446655440000', 'tech_lead', 'Руководитель технического отдела', 'tech.lead@company.com', '1234PAss', 'USER'),
('550e8400-e29b-41d4-a716-446655440001', 'hr_manager', 'Менеджер по персоналу', 'hr.manager@company.com', '1234PAss', 'USER'),
('550e8400-e29b-41d4-a716-446655440002', 'project_manager', 'Руководитель проектов', 'project.manager@company.com', '1234PAss', 'USER');


INSERT INTO contacts (first_name, last_name, telephone, email, owner_id) VALUES
('Анна', 'Смирнова', '+7(926)555-78-90', 'anna.smirnova@yandex.ru', '550e8400-e29b-41d4-a716-446655440000'),
('Иван', 'Петров', '+7(912)123-45-67', 'ivan.petrov@example.com', '550e8400-e29b-41d4-a716-446655440000'),
('Петр', 'Сидоров', '+7(905)765-43-21', 'petr.sidorov@example.com', '550e8400-e29b-41d4-a716-446655440000'),
('Мария', 'Кузнецова', '+7(916)112-22-33', 'maria.kuznetsova@example.com', '550e8400-e29b-41d4-a716-446655440000'),
('Алексей', 'Быков', '+7(901)876-54-32', 'aleksey.byikov@example.com', '550e8400-e29b-41d4-a716-446655440001'),
('Роман', 'Николаев', '+7(917)234-56-78', 'roman.nikolaev@example.com', '550e8400-e29b-41d4-a716-446655440001'),
('Светлана', 'Федорова', '+7(903)345-67-89', 'svetlana.fedorova@example.com', '550e8400-e29b-41d4-a716-446655440001'),
('Константин', 'Морозов', '+7(904)456-78-90', 'konstantin.morozov@example.com', '550e8400-e29b-41d4-a716-446655440002'),
('Виктория', 'Семенова', '+7(902)678-90-12', 'viktoria.semenova@example.com', '550e8400-e29b-41d4-a716-446655440002'),
('Юлия', 'Крылова', '+7(915)321-43-65', 'yulia.krylov@example.com', '550e8400-e29b-41d4-a716-446655440002');

INSERT INTO contact_details (birth_date, company, notes, social_media_profile, tags, contact_id) VALUES
('1990-05-15 00:00:00', 'Yandex', 'Старший разработчик', 'https://social-media.com/anna.smirnova', '#developer #tech', 1),
('1991-06-20 00:00:00', 'Ozon', 'Руководитель отдела', 'https://social-media.com/ivan.petrov', '#manager #it', 2),
('1992-01-15 00:00:00', 'WB', 'Начинающий специалист', 'https://social-media.com/petr.sidorov', '#junior #cloud', 3),
('1993-07-25 00:00:00', 'Sber', 'Дизайнер интерфейсов', 'https://social-media.com/maria.kuznetsova', '#designer #ux', 4),
('1994-08-30 00:00:00', 'HeadHunter', 'Фронтенд разработчик', 'https://social-media.com/aleksey.byikov', '#frontend #react', 5),
('1995-05-22 00:00:00', 'RecruitTech', 'Бэкенд разработчик', 'https://social-media.com/romanback', '#backend #java', 6),
('1996-12-11 00:00:00', 'Farcana', 'Бизнес-консультант', 'https://social-media.com/svetlanacons', '#consultant #business', 7),
('1997-04-02 00:00:00', 'T1', 'Аналитик данных', 'https://social-media.com/konstantindata', '#analyst #data', 8),
('1998-03-17 00:00:00', 'Vk.com', 'UX/UI дизайнер', 'https://social-media.com/viktoriadesign', '#designer #ux', 9),
('1999-11-30 00:00:00', 'TBank', 'Менеджер проекта', 'https://social-media.com/yuliapmanager', '#manager #product', 10);
