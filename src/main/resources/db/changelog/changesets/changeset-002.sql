--changeset boozooka:2
CREATE TYPE MOVING_TYPE AS ENUM('отпуск', 'приход');

CREATE TABLE socks_moving(
    id SERIAL PRIMARY KEY NOT NULL,
    moving_type MOVING_TYPE NOT NULL,
    color VARCHAR(20) NOT NULL,
    cotton_percentage SMALLINT NOT NULL,
    count INTEGER NOT NULL
)