Alter table users drop column is_online ;
ALTER TABLE users add column is_online boolean not null default false;