Alter table users drop column is_online ;
ALTER TABLE chats add column is_online boolean NOT NULL default false;