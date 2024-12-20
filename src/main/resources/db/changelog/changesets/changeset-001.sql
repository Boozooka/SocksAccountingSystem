--changeset boozooka:1

CREATE TABLE socks(
    id SERIAL PRIMARY KEY NOT NULL,
    color VARCHAR(20) NOT NULL,
    cotton_percentage SMALLINT NOT NULL,
    count INTEGER NOT NULL
)