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