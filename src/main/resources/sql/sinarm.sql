INSERT INTO `genders` (`description`,`abbrev`) VALUES
  ('Masculino','M'),
  ('Feminino','F');

INSERT INTO `users_categories` (`description`) VALUES
  ('ADMIN'),
  ('DELEGADO'),
  ('INSTRUTOR'),
  ('PSICOLOGO'),
  ('CIVIL');

INSERT INTO `countries` (`description`) VALUES ('Brasil');

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
