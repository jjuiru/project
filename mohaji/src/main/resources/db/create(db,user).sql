CREATE DATABASE mohaji character set=utf8mb4;
CREATE USER 'mohaji'@'localhost' IDENTIFIED BY 'mysql';
GRANT ALL PRIVILEGES ON mohaji.* TO 'mohaji'@'localhost';
FLUSH PRIVILEGES;