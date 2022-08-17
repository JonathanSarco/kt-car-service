echo -e "Initializing schema..."
psql --host=postgres --username=postgres -w -d db_car -f ./schema.sql &&
echo -e "\nInitializing countries..."
psql --host=postgres --username=postgres -w -d db_car -c "\copy car(brand, model, engine_model, engine_code, torque, power, average_fuel_consumption, co2, cx_s, weight, displacement, block_material, compression_ratio, gearbox_type, tyre, others, traction_type) FROM 'db_vehicles.csv' DELIMITER ';' CSV HEADER"

echo "DB is ready!!!"