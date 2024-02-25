# TimeZone Handling Validation

This project contains automated tests using RestAssured and Cucumber to validate time zone handling during data ingestion and transformation.

## Setup
1. Clone the repository.
2. Ensure you have Java and Maven installed.
3. Set up your API endpoints in the step definitions (`TimeZoneHandlingStepDefs.java`).
4. Run `mvn clean test` to execute the tests.

## Project Structure
- `src/test/resources/features/TimeZoneHandling.feature`: Contains the Gherkin feature file defining the test scenarios.
- `src/test/java/stepDefinitions/TimeZoneHandlingStepDefs.java`: Contains the step definitions for the Gherkin scenarios.
- `src/test/java/runners/TestRunner.java`: Contains the TestNG test runner class.

## Test Execution
- The `setUpData` method in `TimeZoneHandlingStepDefs.java` sets up test data before each scenario.
- The `tearDownData` method in `TimeZoneHandlingStepDefs.java` tears down test data after each scenario.
- The tests can be executed using the TestNG test runner (`TestRunner.java`).

## Dependencies
- RestAssured: For API testing.
- Cucumber: For BDD-style testing.
- TestNG: For test execution.

