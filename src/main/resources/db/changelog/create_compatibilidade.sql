--liquibase formatted sql
--changeset andre.bongiolo:1
CREATE TABLE compatibilidade (
    Id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo_doador BIGINT,
    tipo_receptor BIGINT,
    FOREIGN KEY (tipo_doador) REFERENCES tipo_sanguineo(Id),
    FOREIGN KEY (tipo_receptor) REFERENCES tipo_sanguineo(Id)
);
--rollback DROP compatibilidade