CREATE TABLE users
(
    id        serial  NOT NULL
        PRIMARY KEY,
    username  varchar NOT NULL,
    phone     varchar(16),
    is_online boolean NOT NULL,
    password  varchar,
    image_url varchar
);

CREATE TABLE chats
(
    id          serial NOT NULL
        PRIMARY KEY,
    sender_id   bigint NOT NULL,
    receiver_id bigint NOT NULL,
    CONSTRAINT fk_sender FOREIGN KEY (sender_id) REFERENCES users (id),
    CONSTRAINT fk_receiver FOREIGN KEY (receiver_id) REFERENCES users (id)
);


CREATE TABLE messages
(
    id           serial  NOT NULL
        PRIMARY KEY,
    sender_id    bigint  NOT NULL,
    chat_id      bigint  NOT NULL,
    deliver_time timestamp without time zone DEFAULT (CURRENT_TIMESTAMP AT TIME ZONE 'utc') NOT NULL,
    body         varchar NOT NULL,
    CONSTRAINT fk_sender FOREIGN KEY (sender_id) REFERENCES users (id),
    CONSTRAINT fk_chat FOREIGN KEY (chat_id) REFERENCES chats (id)
);