Alter table chats drop column sender_id;
Alter table chats drop column receiver_id;

ALTER TABLE chats add column user1_id bigint;
ALTER TABLE chats ADD CONSTRAINT fk_user1 FOREIGN KEY (user1_id) REFERENCES users (id);

ALTER TABLE chats add column user2_id bigint;
ALTER TABLE chats ADD CONSTRAINT fk_user2 FOREIGN KEY (user2_id) REFERENCES users (id);


