ALTER TABLE review ADD COLUMN email TEXT;
UPDATE review SET email = 'unknown';
