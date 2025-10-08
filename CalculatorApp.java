import java.util.Scanner;

/**
 * CalculatorApp.java
 * User-interface for interacting with Calculator class.
 * Menu-driven console application.
 */
public class CalculatorApp {
    private Scanner scanner;
    private Calculator calc;

    public CalculatorApp() {
        scanner = new Scanner(System.in);
        calc = new Calculator();
    }

    // Addition handler - lets user pick which overloaded add to call
    private void performAddition() {
        System.out.println("\n-- Addition --");
        System.out.println("Choose type:"); 
        System.out.println("1. Add two integers"); 
        System.out.println("2. Add three integers"); 
        System.out.println("3. Add two doubles"); 
        System.out.print("Enter choice: ");
        int choice = readInt();
        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter first integer: ");
                    int a1 = readInt();
                    System.out.print("Enter second integer: ");
                    int b1 = readInt();
                    int sum1 = calc.add(a1, b1);
                    System.out.println("Result: " + sum1);
                    break;
                case 2:
                    System.out.print("Enter first integer: ");
                    int x = readInt();
                    System.out.print("Enter second integer: ");
                    int y = readInt();
                    System.out.print("Enter third integer: ");
                    int z = readInt();
                    int sum2 = calc.add(x, y, z);
                    System.out.println("Result: " + sum2);
                    break;
                case 3:
                    System.out.print("Enter first double: ");
                    double d1 = readDouble();
                    System.out.print("Enter second double: ");
                    double d2 = readDouble();
                    double sumd = calc.add(d1, d2);
                    System.out.println("Result: " + sumd);
                    break;
                default:
                    System.out.println("Invalid choice for addition."); 
            }
        } catch (Exception e) {
            System.out.println("Error during addition: " + e.getMessage());
        }
    }

    private void performSubtraction() {
        System.out.println("\n-- Subtraction --");
        System.out.print("Enter first integer: ");
        int a = readInt();
        System.out.print("Enter second integer: ");
        int b = readInt();
        int res = calc.subtract(a, b);
        System.out.println("Result: " + res);
    }

    private void performMultiplication() {
        System.out.println("\n-- Multiplication --");
        System.out.print("Enter first number (double): ");
        double a = readDouble();
        System.out.print("Enter second number (double): ");
        double b = readDouble();
        double res = calc.multiply(a, b);
        System.out.println("Result: " + res);
    }

    private void performDivision() {
        System.out.println("\n-- Division --");
        System.out.print("Enter dividend (integer): ");
        int a = readInt();
        System.out.print("Enter divisor (integer): ");
        int b = readInt();
        try {
            double res = calc.divide(a, b);
            System.out.println("Result: " + res);
        } catch (ArithmeticException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // Main menu
    public void mainMenu() {
        while (true) {
            System.out.println("\nWelcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    System.out.println("Thank you for using the Calculator Application. Goodbye!"); 
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1-5."); 
            }
        }
    }

    // Utility - safe integer input
    private int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }

    // Utility - safe double input
    private double readDouble() {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();
        app.mainMenu();
    }
}
