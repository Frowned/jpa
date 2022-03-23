--liquibase formatted sql
--changeset adviters:create-table-playable_character
CREATE SCHEMA IF NOT EXISTS videogame;
CREATE TABLE videogame."character" (
    "name" text NOT NULL, -- name va entre comillas dobles al ser reservado
    age integer NOT NULL,
    sex char NOT NULL DEFAULT 'H', -- al agregar DEFAULT indicamos que si no le enviamos ningún valor quede por defecto 'H'
    weight integer NOT NULL,
    height float4 NOT null,
    bag_id integer not null
);
--rollback DROP TABLE IF EXISTS videogame."character";