DO $$
BEGIN
    CREATE EXTENSION IF NOT EXISTS pgcrypto;

    IF NOT EXISTS (SELECT 1 FROM PG_TABLES WHERE TABLENAME = 'nfe_basic_data') then
        CREATE TABLE nfe_basic_data
        (
            nfe_basic_data_id UUID           NOT NULL DEFAULT GEN_RANDOM_UUID(),
            topic_key         UUID           NOT NULL,
            emission_date     DATE           NOT NULL,
            total_value       NUMERIC(22, 2) NOT NULL DEFAULT 0,
            upload_date_time  TIMESTAMP      NOT NULL,
            CONSTRAINT nfe_basic_data_pk PRIMARY KEY (nfe_basic_data_id),
            CONSTRAINT topic_key_unq UNIQUE (topic_key)
        );

        RAISE INFO 'Table nfe_basic_data was created';
    ELSE
        RAISE INFO 'Table nfe_basic_data already exists';
    END IF;
END
$$;