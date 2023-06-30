# OpenCartPro_V1.0.0

# OpenCart Pro Automation Testing

This repository contains automation test scripts and resources for the OpenCart Pro project. 
The automation tests are designed to ensure the functionality, reliability, and performance of the OpenCart Pro e-commerce platform.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Setup and Configuration](#setup-and-configuration)
- [Running the Tests](#running-the-tests)
- [Test Reports](#test-reports)

## Introduction

The OpenCart Pro Automation Testing project aims to automate various test scenarios for the OpenCart Pro application. 
It utilizes popular automation frameworks and tools such as Selenium, TestNG, Maven and Jenkins to provide robust and reliable test automation.

## Prerequisites

Before running the automation tests, ensure that you have the following prerequisites:

- Java Development Kit (JDK) installed
- Maven build tool installed
- Chrome or Firefox browser installed
- WebDriver executable for the chosen browser (ChromeDriver or GeckoDriver)

## Setup and Configuration

To set up the project and configure it for running the automation tests, follow these steps:

1. Clone the repository to your local machine:

   git clone https://github.com/your-username/open-cart-pro-automation.git

2. Install project dependencies using Maven:

   cd open-cart-pro-automation
   mvn clean install

3. Configure the browser driver path in the test configuration file (`src/test/resources/config.properties`).
4. Update the `webdriver.driver.path` property with the correct path to the WebDriver executable.

5. Modify any other desired configurations or test data in the test configuration file.

## Running the Tests

To execute the automation tests, run the following Maven command:

mvn clean 
mvn validate
mvn compile
mvn test

This command will trigger the test execution and generate test reports.

## Test Reports

After running the tests, the test reports will be generated in the `./ExtentReports` directory. 
Open the HTML report file (`Reort-Date-Time.html`) in a web browser to view the detailed test results.
