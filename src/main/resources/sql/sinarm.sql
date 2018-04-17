USE sinarm_db;

# INSERT DE GENEROS
INSERT INTO sinarm_db.genders (description, abbrev) VALUES
  ('Masculino', 'M'),
  ('Feminino', 'F');

# INSERT DE PERMISSOES DE USUARIOS
INSERT INTO sinarm_db.users_roles (description) VALUES
  ('ADMIN'),
  ('DELEGADO'),
  ('INSTRUTOR'),
  ('PSICOLOGO'),
  ('CIVIL');

# INSERT DE PAISES
INSERT INTO sinarm_db.countries (description) VALUES ('Brasil');

# INSERT DE ESTADOS
INSERT INTO sinarm_db.states (description, abbrev, country_id) VALUES
  ('RONDÔNIA', 'RO', 1),
  ('ACRE', 'AC', 1),
  ('AMAZONAS', 'AM', 1),
  ('RORAIMA', 'RR', 1),
  ('PARÁ', 'PA', 1),
  ('AMAPÁ', 'AP', 1),
  ('TOCANTINS', 'TO', 1),
  ('MARANHÃO', 'MA', 1),
  ('PIAUÍ', 'PI', 1),
  ('CEARÁ', 'CE', 1),
  ('RIO GRANDE DO NORTE', 'RN', 1),
  ('PARAÍBA', 'PB', 1),
  ('PERNAMBUCO', 'PE', 1),
  ('ALAGOAS', 'AL', 1),
  ('SERGIPE', 'SE', 1),
  ('BAHIA', 'BA', 1),
  ('MINAS GERAIS', 'MG', 1),
  ('ESPIRITO SANTO', 'ES', 1),
  ('RIO DE JANEIRO', 'RJ', 1),
  ('SÃO PAULO', 'SP', 1),
  ('PARANÁ', 'PR', 1),
  ('SANTA CATARINA', 'SC', 1),
  ('RIO GRANDE DO SUL', 'RS', 1),
  ('MATO GROSSO DO SUL', 'MS', 1),
  ('MATO GROSSO', 'MT', 1),
  ('GOIÁS', 'GO', 1),
  ('DISTRITO FEDERAL', 'DF', 1);

# INSERT DE CIDADES
INSERT INTO sinarm_db.cities (id, created_at, updated_at, description, state_id) VALUES
  (6, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Guarapuava', 21),
  (7, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Foz do Iguaçu', 21),
  (8, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Garuva', 22),
  (9, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Blumenau', 22),
  (10, '2018-01-20 19:54:20', '2018-01-20 19:54:20', 'Porto Alegre', 23);

# INSERT DE TIPOS DE EXAMES
INSERT INTO sinarm_db.exam_category (id, created_at, updated_at, description, role_id) VALUES
  (2, '2018-02-01 22:48:20', '2018-02-01 22:48:20', 'psicologico', 4),
  (3, '2018-02-01 22:48:29', '2018-02-01 22:48:29', 'teste de tiro', 3);

# INSERT DE REQUISITOS
INSERT INTO sinarm_db.requirements (id, created_at, updated_at, minimal_age, criminal_records, responding_process)
VALUES
  (1, '2018-02-05 21:22:00', '2018-02-05 21:22:00', 25, true, true),
  (2, '2018-02-05 21:22:15', '2018-02-05 21:22:15', 25, true, true);

#INSERT DE EXAMES DOS REQUISITOS
INSERT INTO sinarm_db.requirements_exam_category (requirement_id, exam_category_id) VALUES
  (1, 2),
  (1, 3),
  (2, 2),
  (2, 3);

#INSERT DE CATEGORIAS DE LICENÇAS
INSERT INTO sinarm_db.licenses_categories (id, created_at, updated_at, description, requirement_id, years_to_expirate)
VALUES
  (1, '2018-02-05 21:22:00', '2018-02-05 21:22:00', 'Porte', 1, 5),
  (2, '2018-02-05 21:22:15', '2018-02-05 21:22:15', 'Posse', 2, 5);

#INSERT DE USUARIOS
INSERT INTO sinarm_db.users (id, created_at, updated_at, CPF, criminal_recors, date_of_birth, email, fathers_name,
                             mothers_name, name, nationality, naturalness, password, responding_process,
                             RG, RG_issuing_body, rg_uf, gender_id, role_id) VALUES
  (5, '2018-04-10 19:34:14', '2018-04-10 19:34:14', '444', false, '1970-10-08 00:00:00', 'lucas@lucas.com', 'pai',
      'mae', 'lucas', 'Brasil', 'Foz do Iguaçu',
   '$argon2i$v=19$m=65536,t=2,p=1$av10VlmxPYm7zNmKviuubw$oBivTexoCNBoOWuWgx935XvyJ7MU+Ec7yHINmoKbLRk', false,
   '12313131', 'ssp', 'PARANÁ', 1, 5),
  (6, '2018-04-10 19:34:14', '2018-04-10 19:34:14', '111', false, '1970-10-08 00:00:00', 'lucas@lucas.com', 'pai',
      'mae', 'lucas', 'Brasil', 'Foz do Iguaçu',
   '$argon2i$v=19$m=65536,t=2,p=1$av10VlmxPYm7zNmKviuubw$oBivTexoCNBoOWuWgx935XvyJ7MU+Ec7yHINmoKbLRk', false,
   '12313131', 'ssp', 'PARANÁ', 1, 1),
  (7, '2018-04-10 19:34:14', '2018-04-10 19:34:14', '222', false, '1970-10-08 00:00:00', 'lucas@lucas.com', 'pai',
      'mae', 'instrutor 1', 'Brasil', 'Foz do Iguaçu',
   '$argon2i$v=19$m=65536,t=2,p=1$av10VlmxPYm7zNmKviuubw$oBivTexoCNBoOWuWgx935XvyJ7MU+Ec7yHINmoKbLRk', false,
   '12313131', 'ssp', 'PARANÁ', 1, 3),
  (8, '2018-04-10 19:34:14', '2018-04-10 19:34:14', '333', false, '1970-10-08 00:00:00', 'lucas@lucas.com', 'pai',
      'mae', 'psicologo 1', 'Brasil', 'Foz do Iguaçu',
   '$argon2i$v=19$m=65536,t=2,p=1$av10VlmxPYm7zNmKviuubw$oBivTexoCNBoOWuWgx935XvyJ7MU+Ec7yHINmoKbLRk', false,
   '12313131', 'ssp', 'PARANÁ', 1, 4),
  (11, '2018-04-14 11:31:58', '2018-04-14 11:32:24', '555', false, '1969-12-31 23:48:02', 'psicologo@email.com', 'pai',
       'mae', 'psicologo', 'Brasil', 'Foz do Iguaçu',
   '$argon2i$v=19$m=65536,t=2,p=1$vniMAnTIS92obm6/7486bQ$vk1U3WpbhqWiql3dBf8Ve74tm8z9pS1id56cHEWhZFY', false,
   '12312313', 'ssp', 'PR', 1, 4);

#INSERT DE ENDERECOS
INSERT INTO sinarm_db.address (id, created_at, updated_at, addressNumber, cep, complement, neighborhood, street, city_id)
VALUES
  (1, '2018-04-12 20:01:48', '2018-04-12 20:01:48', '104', '85020-530', 'casa', 'Boqueirão', 'Avenida Cezar Stange',
   10),
  (2, '2018-04-14 11:32:03', '2018-04-14 11:32:03', '104', '85020-530', 'casa', 'Boqueirão', 'Avenida Cezar Stange', 6),
  (3, '2018-04-14 11:32:03', '2018-04-14 11:32:03', '104', '85020-530', 'casa', 'Boqueirão', 'Avenida Cezar Stange', 6),
  (4, '2018-04-14 11:32:03', '2018-04-14 11:32:03', '104', '85020-530', 'casa', 'Boqueirão', 'Avenida Cezar Stange', 6),
  (5, '2018-04-14 11:32:03', '2018-04-14 11:32:03', '104', '85020-530', 'casa', 'Boqueirão', 'Avenida Cezar Stange', 6);

#INSERT DA TABLEA INTERMEDIARIA DE ENDERECOS X USUARIOS
INSERT INTO sinarm_db.address_user (user_id, address_id) VALUES (5, 1), (6, 3), (7, 4), (8, 5), (11, 2);