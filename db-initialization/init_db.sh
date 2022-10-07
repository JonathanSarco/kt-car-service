echo -e "Initializing SCHEMA..."
psql --host=postgres --username=postgres -w -d db_car -f ./schema.sql &&

echo -e "\n Initializing CARS..."
psql --host=postgres --username=postgres -w -d db_car -c "\copy car(brand, model, licence_plate, engine_model, engine_code, gearbox_type, tyre) FROM 'db_vehicles.csv' DELIMITER ';' CSV HEADER"

echo -e "\n Initializing CITIES..."
psql --host=postgres --username=postgres -w -d db_car -c "\copy cities(name, code) FROM 'db_cities.csv' DELIMITER ';' CSV HEADER"

echo -e "\n Initializing CITIES DISTANCES..."
psql --host=postgres --username=postgres -w -d db_car -c "\copy city_to_city(from_city, to_city, distance) FROM 'db_cities_to_cities.csv' DELIMITER ';' CSV HEADER"

echo "DB is ready!!!"