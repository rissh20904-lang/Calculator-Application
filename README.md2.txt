# Calculator Application (Java)

A simple console-based **Calculator Application** demonstrating method overloading in Java.

## Features
- Demonstrates method overloading with `add(int,int)`, `add(double,double)`, `add(int,int,int)`.
- Implements `subtract(int,int)`, `multiply(double,double)`, and `divide(int,int)` with divide-by-zero handling.
- Menu-driven user interface (`CalculatorApp`) for interactive use.
- Input validation and exception handling for robust behavior.

## Files
- `Calculator.java`  — Contains overloaded arithmetic methods.
- `CalculatorApp.java` — Console UI that uses `Calculator` methods.
- `README.md` — This file.

## How to Compile & Run
1. Compile both files:
```bash
javac Calculator.java CalculatorApp.java
```
2. Run the application:
```bash
java CalculatorApp
```

## Sample Interaction
```
Welcome to the Calculator Application!
1. Add Numbers
2. Subtract Numbers
3. Multiply Numbers
4. Divide Numbers
5. Exit
Enter your choice: 1
Choose type:
1. Add two integers
2. Add three integers
3. Add two doubles
Enter choice: 1
Enter first integer: 10
Enter second integer: 20
Result: 30
```

## Notes for Submission
- This solution follows the assignment requirements for method overloading and input handling.
- Make sure to upload both `.java` files to your GitHub repo and submit the repo link to LMS before the deadline.
