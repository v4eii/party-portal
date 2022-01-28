CREATE TABLE users
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY,
    about  VARCHAR(255),
    age    INTEGER NOT NULL,
    email  VARCHAR(255),
    height INTEGER,
    name   VARCHAR(255) NOT NULL,
    rice   BIGINT  NOT NULL,
    role   VARCHAR(255),
    weight INTEGER,
    password VARCHAR(255) NOT NULL,
    authority VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL,
    PRIMARY KEY (id)
)