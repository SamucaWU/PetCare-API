-- ============================================================
--  PetShop API - Schema do Banco de Dados MySQL
-- ============================================================

CREATE DATABASE IF NOT EXISTS petshop_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE petshop_db;

-- ------------------------------------------------------------
-- Tabela: tutor
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS tutor (
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    nome      VARCHAR(100) NOT NULL,
    cpf       VARCHAR(14)  NOT NULL,
    email     VARCHAR(100),
    telefone  VARCHAR(20),
    CONSTRAINT pk_tutor PRIMARY KEY (id),
    CONSTRAINT uq_tutor_cpf UNIQUE (cpf)
);

-- ------------------------------------------------------------
-- Tabela: pet
-- Relacionamento: N pets -> 1 tutor
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS pet (
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    nome        VARCHAR(100) NOT NULL,
    especie     ENUM('CACHORRO','GATO','PEIXE','PASSARO','ROEDOR','OUTRO') NOT NULL,
    idade_meses INT,
    tutor_id    BIGINT      NOT NULL,
    CONSTRAINT pk_pet       PRIMARY KEY (id),
    CONSTRAINT fk_pet_tutor FOREIGN KEY (tutor_id)
        REFERENCES tutor (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- ------------------------------------------------------------
-- Tabela: agendamento
-- Relacionamento: N agendamentos -> 1 pet
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS agendamento (
    id                    BIGINT      NOT NULL AUTO_INCREMENT,
    data_hora             DATETIME    NOT NULL,
    tipo_servico          ENUM('CONSULTA_VETERINARIA','BANHO_E_TOSA','VACINACAO') NOT NULL,
    status                ENUM('AGENDADO','EM_ANDAMENTO','CONCLUIDO','CANCELADO') NOT NULL DEFAULT 'AGENDADO',
    prioridade_emergencia TINYINT(1)  NOT NULL DEFAULT 0,
    observacoes           TEXT,
    pet_id                BIGINT      NOT NULL,
    CONSTRAINT pk_agendamento       PRIMARY KEY (id),
    CONSTRAINT fk_agendamento_pet   FOREIGN KEY (pet_id)
        REFERENCES pet (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- ------------------------------------------------------------
-- Tabela: prontuario
-- Relacionamento: N prontuarios -> 1 pet
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS prontuario (
    id                BIGINT   NOT NULL AUTO_INCREMENT,
    data_atendimento  DATETIME NOT NULL,
    diagnostico       TEXT,
    vacinas_aplicadas TEXT,
    pet_id            BIGINT   NOT NULL,
    CONSTRAINT pk_prontuario       PRIMARY KEY (id),
    CONSTRAINT fk_prontuario_pet   FOREIGN KEY (pet_id)
        REFERENCES pet (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
