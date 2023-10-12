-- data.sql works only in case of in-memory db, not real db
insert into user_details (id, birthdate , name) values (1001, '1990-01-01', 'Mrunalini');
insert into user_details (id, birthdate , name) values (1002, '1990-01-01', 'Anshu');
insert into user_details (id, birthdate , name) values (1003, '1990-01-01', 'Devu');

insert into post (id, description, user_id) values ( 20001, 'I want to learn AWS', 1001);
insert into post (id, description, user_id) values ( 20002, 'I want to learn GCP', 1001);
insert into post (id, description, user_id) values ( 20003, 'I want to learn Azure', 1001);
insert into post (id, description, user_id) values ( 20004, 'I want to learn Azure', 1002);
