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

# INSERT DE USUARIOS, SENHA PADRAO = 123456
INSERT INTO sinarm_db.users (
  id, created_at, updated_at, CPF, criminal_recors, date_of_birth, email, fathers_name,
  mothers_name, name, nationality, naturalness, password, RG, RG_issuing_body, rg_uf, gender_id, role_id)
VALUES
  (1, '2018-02-12 20:19:50', '2018-02-12 20:19:50', '10150393911', null, '2018-02-01 00:00:00', 'lucas@gmail.com',
     'Sidnei', 'vera', 'lucas', 'Brasil', 'Foz', '$2a$05$SD/.zaVczZv9gAVJUNqxK.Ecxc.jBUk.MZ3R3fAxEOHxEu94yPaim',
  '9.886.498-9', 'SSP', 'RG', 1, 1),
  (2, '2018-02-12 20:19:50', '2018-02-12 20:19:50', '111', null, '2018-02-01 00:00:00', 'lucas@gmail.com',
      'Sidnei', 'vera', 'delegado', 'Brasil', 'Foz', '$2a$05$SD/.zaVczZv9gAVJUNqxK.Ecxc.jBUk.MZ3R3fAxEOHxEu94yPaim',
   '9.886.498-9', 'SSP', 'RG', 1, 2),
  (3, '2018-02-12 20:19:50', '2018-02-12 20:19:50', '222', null, '2018-02-01 00:00:00', 'lucas@gmail.com',
      'Sidnei', 'vera', 'instrutor', 'Brasil', 'Foz', '$2a$05$SD/.zaVczZv9gAVJUNqxK.Ecxc.jBUk.MZ3R3fAxEOHxEu94yPaim',
   '9.886.498-9', 'SSP', 'RG', 1, 3),
  (4, '2018-02-12 20:19:50', '2018-02-12 20:19:50', '333', null, '2018-02-01 00:00:00', 'lucas@gmail.com',
      'Sidnei', 'vera', 'psidologo', 'Brasil', 'Foz', '$2a$05$SD/.zaVczZv9gAVJUNqxK.Ecxc.jBUk.MZ3R3fAxEOHxEu94yPaim',
   '9.886.498-9', 'SSP', 'RG', 1, 4),
  (5, '2018-02-12 20:19:50', '2018-02-12 20:19:50', '444', null, '2018-02-01 00:00:00', 'lucas@gmail.com',
      'Sidnei', 'vera', 'civil', 'Brasil', 'Foz', '$2a$05$SD/.zaVczZv9gAVJUNqxK.Ecxc.jBUk.MZ3R3fAxEOHxEu94yPaim',
   '9.886.498-9', 'SSP', 'RG', 1, 5);

# INSERT DE TIPOS DE EXAMES
INSERT INTO sinarm_db.exam_category (id, created_at, updated_at, description, role_id) VALUES
  (2, '2018-02-01 22:48:20', '2018-02-01 22:48:20', 'psicologico', 4),
  (3, '2018-02-01 22:48:29', '2018-02-01 22:48:29', 'teste de tiro', 3);

# INSERT DE REQUISITOS
INSERT INTO sinarm_db.requirements (id, created_at, updated_at, minimal_age, criminal_records, responding_process) VALUES
  (1, '2018-02-05 21:22:00', '2018-02-05 21:22:00', 25, true, true),
  (2, '2018-02-05 21:22:15', '2018-02-05 21:22:15', 25, true, true);

#INSERT DE EXAMES DOS REQUISITOS
INSERT INTO sinarm_db.requirements_exam_category (Requirement_id, exams_id) VALUES
  (1, 2),
  (1, 3),
  (2, 2),
  (2, 3);

#INSERT DE CATEGORIAS DE LICENÇAS
INSERT INTO sinarm_db.licenses_categories (id, created_at, updated_at, description, requirement_id) VALUES
  (1, '2018-02-05 21:22:00', '2018-02-05 21:22:00', 'Porte', 1),
  (2, '2018-02-05 21:22:15', '2018-02-05 21:22:15', 'Posse', 2);