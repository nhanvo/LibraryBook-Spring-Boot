INSERT INTO user (email, password_hash, role, firstname, lastname)
VALUES ('demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ADMIN', 'demo', 'demo');

INSERT INTO user (email, password_hash, role, firstname, lastname)
VALUES ('nhanvo@localhost', '$2a$10$pgzKwJaj8bG.hyOqv4jmK.2dpBPZLDVLrCkSsveCd214sps0sMFO2', 'ADMIN', 'nhan', 'vothanh');


INSERT INTO book (title, author, description, createdat, updateat)
VALUES ('Spring-Boot Program', 'Alex Fuguson', 'This is a book to guide your program with Spring-Boot.', '2005-05-10', '2005-06-12');

INSERT INTO book (title, author, description, createdat, updateat)
VALUES ('H2 Database Engine', 'Robert Amstock', 'This is book help you understand new working with database.', '2006-04-10', '2008-07-8');

INSERT INTO book (title, author, description, createdat, updateat)
VALUES ('Bootstrap For Newbie', 'Micheal Heart', 'This is book help you are improvement GUI skill.', '2011-08-14', '2014-05-17');

