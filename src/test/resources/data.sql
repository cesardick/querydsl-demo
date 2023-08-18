INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('14fe92a7-22eb-49b4-8de1-f327876a4ba5', 'Beatriz Rosângela Mariane Rezende', null, 'FEMALE', 'beatriz_rezende@metroquali.com.br', 15, 2);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('907de82b-d320-4653-943f-ddbc5acf4c1e', 'Joana Amanda Melissa Vieira', '1980-07-21 00:00:00.000000', 'FEMALE', 'joanaamandavieira@unitau.br', 18, 1);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('585875b8-5e1f-4935-8ef9-61980b35449e', 'Luís Miguel Nathan Silveira', '2000-06-19 00:00:00.000000', 'MALE', 'luis_miguel_silveira@tec3.com.br', 23, 5);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('e4a718bc-d1b4-40c7-b71c-df7b6bf24b86', 'Lorenzo Juan Tomás Gonçalves', '1992-12-15 00:00:00.000000', 'MALE', 'lorenzo_goncalves@boldcron.com.br', 12, 1);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('b7614764-6dbe-4ff9-8fcf-4b23d686ae64', 'Yago Luiz das Neves', '1996-11-18 00:00:00.000000', null, 'yago_dasneves@telecall.com', 22, 5);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('34c0624b-7505-4e91-9335-9897e63289d1', 'Tânia Flávia Stefany Baptista', '1979-12-18 00:00:00.000000', 'FEMALE', 'tania.flavia.baptista@afsn.com.br', 22, 2);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('a76173f5-d4fd-40b3-b098-9da43d7c8d8d', 'Marcelo Filipe Victor Ribeiro', '1997-08-15 00:00:00.000000', null, 'marcelo.filipe.ribeiro@cheryamur.com.br', 20, 4);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('cac10b53-149a-426c-8788-0f6617fcb25d', 'Thomas Daniel Gustavo Moreira', '1987-01-12 00:00:00.000000', 'MALE', 'thomas_moreira@carreiradasilva.com', 23, 3);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('a0a199fb-1100-4bc2-9237-f81b92d7dec6', 'Fátima Renata Rodrigues', '1999-01-12 00:00:00.000000', 'FEMALE', 'fatima.renata.rodrigues@endoimplantes.com.br', 13, 2);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('3492a808-70ab-46bd-9ad9-73d274603632', 'Patrícia Antonella Rodrigues', '1988-09-30 00:00:00.000000', null, 'patriciaantonellarodrigues@pig.com.br', 15, 5);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('6665839a-8433-4c66-ae37-925d8e572018', 'Aline Jennifer Clarice da Silva', '1965-07-15 00:00:00.000000', 'FEMALE', 'aline.jennifer.dasilva@vilarreal.com.br', 51, 2);
INSERT INTO person (id, name, birth_date, gender, email, age, married_years) VALUES ('675e553a-96de-495e-8308-ce3f77320445', 'André Heitor Anderson Assis', '1946-08-15 00:00:00.000000', 'MALE', 'andreheitorassis@a.com', 25, 3);

INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('907de82b-d320-4653-943f-ddbc5acf4c1e', 'Rua A', 'São Paulo', 'SP', 'PRIMARY', '907de82b-d320-4653-943f-ddbc5acf4c1e');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('675e553a-96de-495e-8308-ce3f77320445', 'Rua B', 'Rio de Janeiro', 'RJ', 'WORK', '675e553a-96de-495e-8308-ce3f77320445');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('cac10b53-149a-426c-8788-0f6617fcb25d', 'Rua C', 'Belo Horizonte', 'MG', 'MAIL', 'cac10b53-149a-426c-8788-0f6617fcb25d');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('34c0624b-7505-4e91-9335-9897e63289d1', 'Rua D', 'Brasília', 'DF', 'PRIMARY', '34c0624b-7505-4e91-9335-9897e63289d1');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('6665839a-8433-4c66-ae37-925d8e572018', 'Rua E', 'Salvador', 'BA', 'WORK', '6665839a-8433-4c66-ae37-925d8e572018');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('a0a199fb-1100-4bc2-9237-f81b92d7dec6', 'Rua F', 'Fortaleza', 'CE', 'MAIL', 'a0a199fb-1100-4bc2-9237-f81b92d7dec6');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('3492a808-70ab-46bd-9ad9-73d274603632', 'Rua G', 'Manaus', 'AM', 'PRIMARY', '3492a808-70ab-46bd-9ad9-73d274603632');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('585875b8-5e1f-4935-8ef9-61980b35449e', 'Rua H', 'Recife', 'PE', 'WORK', '585875b8-5e1f-4935-8ef9-61980b35449e');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('a76173f5-d4fd-40b3-b098-9da43d7c8d8d', 'Rua I', 'Natal', 'RN', 'MAIL', 'a76173f5-d4fd-40b3-b098-9da43d7c8d8d');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('b7614764-6dbe-4ff9-8fcf-4b23d686ae64', 'Rua J', 'Porto Alegre', 'RS', 'PRIMARY', 'b7614764-6dbe-4ff9-8fcf-4b23d686ae64');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('e4a718bc-d1b4-40c7-b71c-df7b6bf24b86', 'Rua K', 'Curitiba', 'PR', 'WORK', 'e4a718bc-d1b4-40c7-b71c-df7b6bf24b86');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('14fe92a7-22eb-49b4-8de1-f327876a4ba5', 'Rua L', 'Florianópolis', 'SC', 'MAIL', '14fe92a7-22eb-49b4-8de1-f327876a4ba5');
INSERT INTO address (id, street, city, uf, type, person_id) VALUES ('907de82b-d320-4653-943f-ddbc5acf4c1f', 'Rua A', 'São Paulo', 'SP', 'PRIMARY', 'a76173f5-d4fd-40b3-b098-9da43d7c8d8d');
