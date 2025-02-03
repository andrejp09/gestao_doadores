--liquibase formatted sql
--changeset andre.bongiolo:1
CREATE TABLE endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(10),
    logradouro VARCHAR(255),
    numero INT,
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(2)
);
--rollback DROP endereco