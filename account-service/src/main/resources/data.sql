CREATE DATABASE bank_service_db;

USE bank_service_db;

CREATE TABLE customer_account (
                                  id INT AUTO_INCREMENT PRIMARY KEY,
                                  account_number VARCHAR(20) NOT NULL,
                                  full_name VARCHAR(100) NOT NULL,
                                  date_of_birth DATE NOT NULL,
                                  account_type VARCHAR(20) NOT NULL,
                                  account_status VARCHAR(20) NOT NULL,
                                  balance DECIMAL(15, 2) NOT NULL,
                                  last_transaction_date DATE
);

INSERT INTO customer_account (account_number, full_name, date_of_birth, account_type, account_status, balance, last_transaction_date)
VALUES
    ('1234567890', 'John Doe', '1980-01-01', 'Savings', 'Active', 1000.00, '2024-09-01'),
    ('2345678901', 'Jane Smith', '1990-02-02', 'Checking', 'Active', 2000.00, '2024-10-01'),
    ('3456789012', 'Alice Johnson', '1975-03-03', 'Savings', 'Inactive', 500.00, '2024-08-01');