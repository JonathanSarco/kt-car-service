CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS car (
  id                        uuid DEFAULT uuid_generate_v4 (),
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