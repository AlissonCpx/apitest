CREATE TABLE user_model
(
  id                        BIGINT       NOT NULL
    CONSTRAINT user_model_pkey
    PRIMARY KEY,
  created_at                TIMESTAMP,
  updated_at                TIMESTAMP,
  admin                     BOOLEAN,
  email                     VARCHAR(255) NOT NULL
    CONSTRAINT uk_la8xty622mpbfdhq2iixt9lhu
    UNIQUE,
  last_authorization_status VARCHAR(255),
  name                      VARCHAR(255) NOT NULL,
  password                  VARCHAR(255) NOT NULL,
  surname                   VARCHAR(255)
);
CREATE SEQUENCE sequsermodel;

CREATE TABLE phone_model
(
  id         BIGINT NOT NULL
    CONSTRAINT phone_model_pkey
    PRIMARY KEY,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  ddd        VARCHAR(255),
  number     VARCHAR(255),
  type       VARCHAR(255)
);
CREATE SEQUENCE seqphonemodel;

CREATE TABLE crm_model
(
  id         BIGINT       NOT NULL
    CONSTRAINT crm_model_pkey
    PRIMARY KEY,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  crm        VARCHAR(255) NOT NULL,
  specialty  VARCHAR(255),
  uf         VARCHAR(255) NOT NULL
);
CREATE SEQUENCE seqcrmmodel;

CREATE TABLE user_model_crms
(
  user_model_id BIGINT NOT NULL
    CONSTRAINT fk6p64ycbnyjrs3cbu463sedn0w
    REFERENCES user_model,
  crms_id       BIGINT NOT NULL
    CONSTRAINT uk_hwy2eteyinuha14xkjt52cil3
    UNIQUE
    CONSTRAINT fknblgvymt7iicb38e1j8yf4b38
    REFERENCES crm_model
);


CREATE TABLE user_model_mobile_phones
(
  user_model_id    BIGINT NOT NULL
    CONSTRAINT fk2mg09uerjc1dc1odxmdm7o8mw
    REFERENCES user_model,
  mobile_phones_id BIGINT NOT NULL
    CONSTRAINT uk_qthai0lu0cif3mnslxk788f2
    UNIQUE
    CONSTRAINT fkj6x73hvyrxla6f1vxl6ugxo9y
    REFERENCES phone_model
);


