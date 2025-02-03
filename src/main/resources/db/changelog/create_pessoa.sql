--liquibase formatted sql
--changeset andre.bongiolo:1
CREATE TABLE pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(14),
    rg VARCHAR(12),
    data_nascimento DATE,
    sexo VARCHAR(10),
    mae VARCHAR(255),
    pai VARCHAR(255),
    email VARCHAR(255),
    telefone_fixo VARCHAR(15),
    celular VARCHAR(15),
    altura decimal(38,2),
    peso BIGINT,
    tipo_sanguineo_id bigint,
    endereco_id BIGINT,
    FOREIGN KEY (tipo_sanguineo_id) REFERENCES tipo_sanguineo(id),
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);
--rollback DROP pessoa