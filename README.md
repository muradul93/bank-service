
```markdown
# Transaction Service

This is a Spring Boot application for managing transactions. It includes a REST API for creating and retrieving transactions, and it communicates with an account service to manage account balances.

## Prerequisites

- Java 17
- Maven
- MySQL

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/muradul93/bank-service.git
cd transaction-service
```

### Configure the Database

1. Create a MySQL database named `transaction_db`.
2. Update the `application.properties` file located in `src/main/resources` with your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/transaction_db
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

### Create a Transaction

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

### Get a Transaction by ID

```http
GET /transactions/{id}
```

**Example:**

```bash
curl -X GET "http://localhost:8080/transactions/1"
```

### Get All Transactions

```http
GET /transactions
```

**Example:**

```bash
curl -X GET "http://localhost:8080/transactions"
```

## Running Tests

To run the tests, use the following command:

```bash
mvn test
```

## License

This project is licensed under the MIT License.
```
