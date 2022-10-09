CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS car (
  id                        UUID DEFAULT uuid_generate_v4(),
  brand                     VARCHAR(100) NOT NULL,
  model                     VARCHAR(100) NOT NULL,
  licence_plate             VARCHAR(100),
  engine_model              VARCHAR(100),
  engine_code               VARCHAR(255),
  gearbox_type              VARCHAR(100),
  tyre                      VARCHAR(255),
  CONSTRAINT car_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS repair_shop (
    id                      UUID DEFAULT uuid_generate_v4(),
    name                    VARCHAR(100) NOT NULL,
    address                 TEXT,
    supported_car_brands    TEXT[],
    opening_hour            NUMERIC,
    closing_hour            NUMERIC,
    creation_date           DATE,
    CONSTRAINT repair_shop_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cities (
   id                      UUID DEFAULT uuid_generate_v4(),
   name                    VARCHAR(100) NOT NULL,
   code                    VARCHAR(10),
   CONSTRAINT city_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS city_to_city (
  id                      UUID DEFAULT uuid_generate_v4(),
  from_city               VARCHAR(10) NOT NULL,
  to_city                 VARCHAR(10) NOT NULL,
  distance                NUMERIC,
  CONSTRAINT city_to_city_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS car_problem (
   id                      UUID DEFAULT uuid_generate_v4(),
   description             TEXT NOT NULL,
   part_broken             VARCHAR(100),
   broken_date             DATE,
   CONSTRAINT car_problem_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS car_to_repair_shop (
   id                      UUID DEFAULT uuid_generate_v4(),
   repair_shop_id          UUID,
   car_id                  UUID,
   car_problem_id          UUID,
   registered_problem_date DATE,
   CONSTRAINT car_to_repair_shop_pkey PRIMARY KEY (id),
   CONSTRAINT car_to_repair_shop_repair_shop_fkey FOREIGN KEY (repair_shop_id) REFERENCES repair_shop(id),
   CONSTRAINT car_to_repair_shop_car_fkey FOREIGN KEY (car_id) REFERENCES car(id),
   CONSTRAINT car_to_repair_shop_car_problem_fkey FOREIGN KEY (car_problem_id) REFERENCES car_problem(id)
);