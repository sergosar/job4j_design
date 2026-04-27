INSERT INTO roles (role)
VALUES ('ADMIN'),
       ('USER');

INSERT INTO users (name, role_id)
VALUES ('Alice', 1),
       ('Bob', 2);

INSERT INTO rules (rule)
VALUES ('READ'),
       ('WRITE');

INSERT INTO roles_rules (role_id, rule_id)
VALUES (1, 1),
       (1, 2),
       (2, 1);

INSERT INTO states (state)
VALUES ('NEW'),
       ('DONE');

INSERT INTO categories (category)
VALUES ('BUG'),
       ('FEATURE');

INSERT INTO items (item, user_id, category_id, state_id)
VALUES ('Fix login bug', 1, 1, 1),
       ('Add new dashboard', 2, 2, 2);

INSERT INTO comments (comment, item_id)
VALUES ('This is critical', 1),
       ('Looks good', 2);

INSERT INTO attachs (attach, item_id)
VALUES ('screenshot1.png', 1),
       ('design.pdf', 2);