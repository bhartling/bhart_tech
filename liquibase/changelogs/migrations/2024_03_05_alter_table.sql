ALTER TABLE chungus_picklist
ADD COLUMN email VARCHAR(100);

UPDATE chungus_picklist
SET email = 'default@bhart.com';

ALTER TABLE chungus_picklist
ALTER COLUMN email SET NOT NULL;
