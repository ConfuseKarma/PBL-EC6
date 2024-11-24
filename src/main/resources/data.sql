-- Desabilita integridade referencial
ALTER TABLE TB_USER SET REFERENTIAL_INTEGRITY FALSE;

-- Limpa a tabela
TRUNCATE TABLE TB_USER;

-- Habilita integridade referencial
ALTER TABLE TB_USER SET REFERENTIAL_INTEGRITY TRUE;

-- Insere usuários (incluindo o admin)
INSERT INTO TB_USER (NAME, EMAIL, REGISTRATION_DATE, PASSWORD, SECRET, USER_ROLE, USER_GENDER, IMAGE, IS_USING_2FA, BIO, ACTIVE) 
VALUES 
('Admin', 'admin@test.com', NOW(), '$2a$12$E.GBokDDH4SeVF22dacPpOnzll0ZnbQEexdf3sTcogvw1EJYzH.EK', NULL, 'ADMIN', 'OTHER', NULL, false, 'Administrador do sistema', true), 
('Client', 'client@test.com', NOW(), '$2b$12$rkB7qfO63uWwJ9KDccT/puXNtQtrT62sXirzJNNkTi1TruRr0NaPW', NULL, 'CLIENT', 'MALE', NULL, false, 'Cliente regular', true), 
('Critic', 'critic@test.com', NOW(), '$2b$12$ieYk9tpZA45fd/tnosOeZ.t3zkVkNrXwm2ehNyr6QU0Afck73J9Sy', NULL, 'CRITIC', 'FEMALE', NULL, false, 'Crítico regular', true);

-- Password Admin: admin_password

-- Exemplo de Inserção de Mídias:
-- Example 1
INSERT INTO TB_MEDIA (TITLE, SUBTITLE, ID_GENRE, RELEASE_DATE, ID_DIRECTOR, IMAGE, RATING, SYNOPSIS, YEAR, PRODUCTION_COMPANY)
VALUES 
('The Godfather', 'A story of revenge and loyalty', 6, '1972-03-24 00:00:00', 1, 'godfather_image.jpg', '9.2', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 1972, 'Paramount Pictures');

-- Example 2
INSERT INTO TB_MEDIA (TITLE, SUBTITLE, ID_GENRE, RELEASE_DATE, ID_DIRECTOR, IMAGE, RATING, SYNOPSIS, YEAR, PRODUCTION_COMPANY)
VALUES 
('The Matrix', 'The revolution of reality', 16, '1999-03-31 00:00:00', 2, 'matrix_image.jpg', '8.7', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 1999, 'Warner Bros.');

-- Example 3
INSERT INTO TB_MEDIA (TITLE, SUBTITLE, ID_GENRE, RELEASE_DATE, ID_DIRECTOR, IMAGE, RATING, SYNOPSIS, YEAR, PRODUCTION_COMPANY)
VALUES 
('The Lion King', 'Simba\'s journey to become king', 3, '1994-06-15 00:00:00', 3, 'lionking_image.jpg', '8.5', 'A lion prince is cast out of his pride by his cruel uncle, who claims the throne. With the help of a curious pair of friends, he returns to reclaim his birthright.', 1994, 'Walt Disney Pictures');

-- Example 4
INSERT INTO TOTALMEDIA.TB_MEDIA (TITLE, SUBTITLE, ID_GENRE, RELEASE_DATE, ID_DIRECTOR, IMAGE, RATING, SYNOPSIS, YEAR, PRODUCTION_COMPANY)
VALUES 
('Interstellar', 'The search for a new home for humanity', 16, '2014-11-07 00:00:00', 4, 'interstellar_image.jpg', '8.6', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity\'s survival.', 2014, 'Paramount Pictures');

-- Example 5
INSERT INTO TB_MEDIA (TITLE, SUBTITLE, ID_GENRE, RELEASE_DATE, ID_DIRECTOR, IMAGE, RATING, SYNOPSIS, YEAR, PRODUCTION_COMPANY)
VALUES 
('Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.', 16, '2010-07-16 00:00:00', 5, 'inception_image.jpg', '8.8', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.', 2010, 'Warner Bros.');
