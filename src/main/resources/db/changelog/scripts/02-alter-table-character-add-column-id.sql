--liquibase formatted sql
--changeset adviters:alter-table-character-add-column-id
ALTER TABLE videogame."character" ADD COLUMN id SERIAL PRIMARY KEY;

--rollback ALTER TABLE videogame."character" DROP COLUMN IF EXISTS id;