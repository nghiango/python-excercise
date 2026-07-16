# TDD Guide for Tax Calculator

## Setup Complete ✅

### Files Created:
- `Tax.java` - Main tax calculation logic
- `TaxJUnitTest.java` - JUnit test cases
- `junit-4.13.2.jar` - JUnit library
- `hamcrest-core-1.3.jar` - Required dependency

## How to Run Tests

### Run all tests:
```bash
java -cp .:src:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TaxJUnitTest
```

### Compile and test:
```bash
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar src/Tax.java TaxJUnitTest.java
java -cp .:src:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TaxJUnitTest
```

## TDD Workflow

### 1. Red - Write a failing test
Add new test methods to `TaxJUnitTest.java`

### 2. Green - Make the test pass
Modify `Tax.java` to make tests pass

### 3. Refactor - Clean up the code
Improve code without changing behavior

## Current Test Coverage

✅ Zero salary
✅ First tax bracket (0-5M)
✅ Second tax bracket (5-10M)
✅ Third tax bracket (10-18M)
✅ Exact bracket boundaries
✅ Vietnamese tax system
✅ Negative salary edge case
✅ Large salary calculation

## Next Steps for TDD Practice

1. **Add more edge cases** (e.g., very small decimal salaries)
2. **Test invalid inputs** (e.g., mismatched array lengths)
3. **Add performance tests** for large datasets
4. **Test different bracket configurations**
