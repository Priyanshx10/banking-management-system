# Banking Management System — P-01

A console-based Java banking application built as the first project in the Java Backend portfolio.

## Features

- Customer creation and validation
- Bank account creation
- Automatic account-number generation
- Multiple accounts per customer
- Savings and Current account types
- Deposit and withdrawal
- Insufficient-balance validation
- Account lookup and account validation
- Account-to-account transfers
- Transaction history
- Basic savings interest calculation
- Exception handling
- Interactive menu
- Git/GitHub workflow

## Project Structure

```text
banking-management-system/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java
│           ├── Customer.java
│           ├── BankAccount.java
│           ├── SavingsAccount.java
│           ├── CurrentAccount.java
│           ├── Transaction.java
│           ├── BankingException.java
│           └── BankingService.java
├── .gitignore
└── README.md
```

## Run locally

From the project root:

```powershell
javac src/main/java/*.java
java -cp src/main/java Main
```

The application starts with a demo customer and savings account.

## Engineering Concepts

- Encapsulation
- Composition
- Inheritance
- Polymorphism
- Abstract classes
- Collections (`Map`, `List`)
- Exception handling
- Static ID generation
- Date/time handling
- Basic business validation

## Portfolio Completion Standard

P-01 is considered complete after:

1. All required features are implemented.
2. The application compiles and runs.
3. Core and edge cases are tested.
4. Code is committed to Git.
5. The completed branch is pushed to GitHub.
6. README documentation is present.

## Important note about deployment

This project is intentionally a console Java application. A browser-accessible deployment would require turning it into a REST/Spring Boot application, which belongs to the later Spring Boot projects in the portfolio.

For P-01, the recommended deployment milestone is packaging/running the Java application on an EC2 instance. A public HTTP API will be introduced in the later REST projects.
