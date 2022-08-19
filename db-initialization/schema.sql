CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS car (
  id                        UUID DEFAULT uuid_generate_v4(),
  brand                     VARCHAR(100) NOT NULL,
  model                     VARCHAR(100) NOT NULL,
  engine_model              VARCHAR(100),
  engine_code               VARCHAR(255),
  torque                    VARCHAR(100),
  power                     VARCHAR(100),
  average_fuel_consumption  DOUBLE PRECISION,
  co2                       NUMERIC,
  cx_s                      VARCHAR(255),
  weight                    VARCHAR(255),
  displacement              NUMERIC,
  block_material            VARCHAR(100),
  compression_ratio         DOUBLE PRECISION,
  gearbox_type              VARCHAR(100),
  tyre                      VARCHAR(255),
  others                    VARCHAR(100),
  traction_type             VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS repair_shop (
    id                      UUID DEFAULT uuid_generate_v4(),
    name                    VARCHAR(100) NOT NULL,
    supported_car_brands    TEXT[],
    opening_hour            NUMERIC,
    closing_hour            NUMERIC,
    creation_date           DATE,
    CONSTRAINT repair_shop_pkey PRIMARY KEY (id)
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
   CONSTRAINT car_to_repair_shop_pkey PRIMARY KEY (id)
);