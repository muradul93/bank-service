```markdown
# Bank Service

This is a Spring Boot application for managing transactions. It includes a REST API for creating and retrieving transactions, and it communicates with an account service to manage account balances.

## Prerequisites

- Java 8 or higher
- Maven
- MySQL
- Postman

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/muradul93/bank-service.git
cd bank-service
```

### Configure the Database

1. Create a MySQL database named `transaction_db`.
2. Run the following script to create the `customer_account` table and insert sample data:

```sql
CREATE DATABASE transaction_db;

USE transaction_db;

CREATE TABLE customer_account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    account_status VARCHAR(20) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL,
    last_transaction_date DATE
);

INSERT INTO customer_account (account_number, full_name, date_of_birth, account_type, account_status, balance, last_transaction_date) VALUES
('1234567890', 'John Doe', '1980-01-01', 'Savings', 'Active', 1000.00, '2023-01-01'),
('2345678901', 'Jane Smith', '1990-02-02', 'Checking', 'Active', 2000.00, '2023-02-01'),
('3456789012', 'Alice Johnson', '1975-03-03', 'Savings', 'Inactive', 500.00, '2023-03-01');
```

3. Update the `application.properties` file located in `src/main/resources` with your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/transaction_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Build the Application

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Endpoints

### Get Account Details

```http
GET /accounts/{accountNumber}
```

**Example:**

```bash
curl -X GET "http://localhost:8080/accounts/1234567890"
```

**Response:**

```json
{
  "id": 1,
  "accountNumber": "1234567890",
  "fullName": "John Doe",
  "dateOfBirth": "1980-01-01",
  "accountType": "Savings",
  "accountStatus": "Active",
  "balance": 1000.00,
  "lastTransactionDate": "2023-01-01"
}
```

### Transfer Amount

```http
POST /transactions
```

**Parameters:**

- `senderAccountNumber` (String): The account number of the sender.
- `recipientAccountNumber` (String): The account number of the recipient.
- `amount` (Double): The amount to be transferred.

**Example:**

```bash
curl -X POST "http://localhost:8080/transactions" -d "senderAccountNumber=1234567890&recipientAccountNumber=2345678901&amount=100.00"
```

**Response:**

```json
{
  "id": 1,
  "senderAccountNumber": "1234567890",
  "recipientAccountNumber": "2345678901",
  "amount": 100.00,
  "transactionDate": "2023-10-01"
}
```

## Running Tests

To run the tests, use the following command:

```bash
mvn test
```

## License

This project is licensed under the MIT License.
```
