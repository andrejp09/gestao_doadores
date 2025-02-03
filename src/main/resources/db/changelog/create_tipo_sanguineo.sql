--liquibase formatted sql
--changeset andre.bongiolo:1
CREATE TABLE tipo_sanguineo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(3) UNIQUE
);
--rollback DROP tipo_sanguineo