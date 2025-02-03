--liquibase formatted sql
--changeset andre.bongiolo:1
INSERT INTO tipo_sanguineo (id, tipo) VALUES
(1, 'A+'),
(2, 'A-'),
(3, 'B+'),
(4, 'B-'),
(5, 'AB+'),
(6, 'AB-'),
(7, 'O+'),
(8, 'O-');
--rollback delete tipo_sanguineo