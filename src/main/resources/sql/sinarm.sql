use sinarm_db;

# INSERT DE GENEROS
INSERT INTO `genders` (`description`,`abbrev`) VALUES
  ('Masculino','M'),
  ('Feminino','F');

# INSERT DE PERMISSOES DE USUARIOS
INSERT INTO `users_roles` (`description`) VALUES
  ('ADMIN'),
  ('DELEGADO'),
  ('INSTRUTOR'),
  ('PSICOLOGO'),
  ('CIVIL');


# INSERT DE PAISES
INSERT INTO `countries` (`description`) VALUES ('Brasil');

# INSERT DE ESTADOS
INSERT INTO `states`(`description`,`abbrev`,`country_id`) VALUES
  ('RONDÔNIA','RO',1),
  ('ACRE','AC',1),
  ('AMAZONAS','AM',1),
  ('RORAIMA','RR',1),
  ('PARÁ','PA',1),
  ('AMAPÁ','AP',1),
  ('TOCANTINS','TO',1),
  ('MARANHÃO','MA',1),
  ('PIAUÍ','PI',1),
  ('CEARÁ','CE',1),
  ('RIO GRANDE DO NORTE','RN',1),
  ('PARAÍBA','PB',1),
  ('PERNAMBUCO','PE',1),
  ('ALAGOAS','AL',1),
  ('SERGIPE','SE',1),
  ('BAHIA','BA',1),
  ('MINAS GERAIS','MG',1),
  ('ESPIRITO SANTO','ES',1),
  ('RIO DE JANEIRO','RJ',1),
  ('SÃO PAULO','SP',1),
  ('PARANÁ','PR',1),
  ('SANTA CATARINA','SC',1),
  ('RIO GRANDE DO SUL','RS',1),
  ('MATO GROSSO DO SUL','MS',1),
  ('MATO GROSSO','MT',1),
  ('GOIÁS','GO',1),
  ('DISTRITO FEDERAL','DF',1);


# INSERT DE CIDADES
INSERT INTO sinarm_db.cities (id, created_at, updated_at, description, state_id) VALUES (6, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Guarapuava', 21);
INSERT INTO sinarm_db.cities (id, created_at, updated_at, description, state_id) VALUES (7, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Foz do Iguaçu', 21);
INSERT INTO sinarm_db.cities (id, created_at, updated_at, description, state_id) VALUES (8, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Garuva', 22);
INSERT INTO sinarm_db.cities (id, created_at, updated_at, description, state_id) VALUES (9, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Blumenau', 22);
INSERT INTO sinarm_db.cities (id, created_at, updated_at, description, state_id) VALUES (10, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Porto Alegre', 23);

# INSERT DE USUARIOS, SENHA PADRAO = 123456
INSERT INTO sinarm_db.users (id, created_at, updated_at, cpf, date_of_birth, email, name, password, gender_id, role_id) VALUES (1, '2018-01-20 19:54:20', '2018-01-20 19:54:20', '111', '2018-01-20 19:54:20', 'email@email.com', 'nome do admin', '$2a$05$99WnoBXA/g14iw6AHheWSeOzPJd67HMgtzhv9NS0NA1nEr1SLSa1G', 1, 1);
INSERT INTO sinarm_db.users (id, created_at, updated_at, cpf, date_of_birth, email, name, password, gender_id, role_id) VALUES (2, '2018-01-20 19:54:20', '2018-01-20 19:54:20', '333', '2018-01-20 19:54:20', 'email@email.com', 'nome do instrutor', '$2a$05$cO4oBK050mY8fCVu4lz1GuJ9ap1O5t0nxcilCu.26hLoX6ARoPaNy', 1, 3);
INSERT INTO sinarm_db.users (id, created_at, updated_at, cpf, date_of_birth, email, name, password, gender_id, role_id) VALUES (3, '2018-01-20 19:54:20', '2018-01-20 19:54:20', '222', '2018-01-20 19:54:20', 'email@email.com', 'nome do delegado', '$2a$05$lcXq1moicMqXKhihCNkLOe/OJi4G3FPx2K8v/WZ9Y5CBr8u8gLx6u', 1, 2);
INSERT INTO sinarm_db.users (id, created_at, updated_at, cpf, date_of_birth, email, name, password, gender_id, role_id) VALUES (4, '2018-01-20 19:54:20', '2018-01-20 19:54:20', '444', '2018-01-20 19:54:20', 'email@email.com', 'nome do psicologo', '$2a$05$zmpnOyuqQKhB0auQwipUuOO5Wm/6QBeMpzqwvO9dYY2oCPEtPN8P6', 1, 4);
INSERT INTO sinarm_db.users (id, created_at, updated_at, cpf, date_of_birth, email, name, password, gender_id, role_id) VALUES (5, '2018-01-20 19:54:20', '2018-01-20 19:54:20', '555', '2018-01-20 19:54:20', 'email@email.com', 'nome do cliente', '$2a$05$YUUdCRjfuo2gFHm.bjjsoO7oS7DJloAWaF/rNYB2rfWyHKg0GN70W', 1, 5);
