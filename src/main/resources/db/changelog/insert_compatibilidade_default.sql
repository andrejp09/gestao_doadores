--liquibase formatted sql
--changeset andre.bongiolo:1
INSERT INTO compatibilidade (tipo_doador, tipo_receptor) VALUES
(1, 1), (1, 5),
(2, 1), (2, 2), (2, 5), (2, 6),
(3, 3), (3, 5),
(4, 3), (4, 4), (4, 5), (4, 6),
(5, 5),
(6, 5), (6, 6),
(7, 1), (7, 3), (7, 5), (7, 7),
(8, 1), (8, 2), (8, 3), (8, 4), (8, 5), (8, 6), (8, 7), (8, 8);
--rollback delete tipo_sanguineo