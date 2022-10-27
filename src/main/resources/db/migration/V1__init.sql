CREATE TABLE refs
(
    ref_id serial,
    long_ref text NOT NULL,
    short_key varchar(20) NOT NULL,
    PRIMARY KEY (ref_id)
);

CREATE UNIQUE INDEX short_key_idx ON refs (short_key);