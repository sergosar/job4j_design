CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR(20)
);

CREATE TABLE users
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR,
    role_id INT REFERENCES roles (id)
);

CREATE TABLE rules
(
    id   SERIAL PRIMARY KEY,
    rule TEXT
);

CREATE TABLE roles_rules
(
    id      SERIAL PRIMARY KEY,
    role_id INT REFERENCES roles (id),
    rule_id INT REFERENCES rules (id)
);

CREATE TABLE states
(
    id    SERIAL PRIMARY KEY,
    state TEXT
);

CREATE TABLE categories
(
    id       SERIAL PRIMARY KEY,
    category TEXT
);


CREATE TABLE items
(
    id          SERIAL PRIMARY KEY,
    item        TEXT,
    user_id     INT REFERENCES users (id),
    category_id INT REFERENCES categories (id),
    state_id    INT REFERENCES states (id)
);

CREATE TABLE comments
(
    id      SERIAL PRIMARY KEY,
    comment TEXT,
    item_id INT REFERENCES items (id)
);

CREATE TABLE attachs
(
    id      SERIAL PRIMARY KEY,
    attach  TEXT,
    item_id INT REFERENCES items (id)
);


