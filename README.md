# OrangeHRM Test Automation

This repository contains the test automation framework for the **OrangeHRM** application. The goal of this repository is to provide automated tests that ensure the correctness and stability of the OrangeHRM application.

You can access the OrangeHRM demo application here: [OrangeHRM Live Demo](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Directory Structure](#directory-structure)

## Project Overview

OrangeHRM is an open-source Human Resource Management (HRM) solution. This project focuses on automating the testing of various features within the OrangeHRM application, including login functionality, user management, and employee records.

The test automation framework includes:

- **Functional Test Cases** for user interactions
- **Regression Tests** to ensure existing features are not broken
- **Cross-Browser Testing** for compatibility

## Technologies Used

- **Selenium WebDriver**: For browser automation
- **TestNG**: For test execution and reporting
- **Maven**: For project build and dependency management
- **Java**: The programming language used for test scripts
- **JUnit**: For unit testing where applicable
- **Page Object Model (POM)**: For better test organization and maintainability

## Setup and Installation

### Prerequisites

Before setting up the project, ensure that you have the following installed:

- **Java** (JDK 8 or later)
- **Maven**
- **Git** (for version control)
- **IDE** (e.g., IntelliJ IDEA or Eclipse)
- **WebDriverManager** (e.g., Maven dependency)

Clone this repository to your local machine:
   ```bash
   git clone https://github.com/koushikmal/OrangeHRM.git
```
## Directory Structure
```bash
OrangeHRM/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pageobjects/           # Page Object Model (POM) classes
│   │       └── utils/                 # Utility classes (e.g., WebDriver manager, config)
│   ├── test/
│   │   └── java/
│   │       ├── tests/                 # Test scripts
│   │       └── resources/
│   │           └── testng.xml         # TestNG configuration file
├── pom.xml                           # Maven project configuration
├── README.md                         # Project documentation
└── .gitignore                        # Git ignore file for dependencies, IDE files, etc.


