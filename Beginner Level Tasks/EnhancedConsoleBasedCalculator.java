import java.util.Scanner;

public class EnhancedConsoleBasedCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueCalculator = true;

        System.out.println("===== Welcome to the Enhanced Calculator =====");

        while (continueCalculator) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> basicArithmetic(sc);
                case 2 -> scientificCalculations(sc);
                case 3 -> unitConversions(sc);
                case 4 -> {
                    System.out.println("Thanks for using the calculator. Have a great day!");
                    continueCalculator = false;
                }
                default -> System.out.println("Oops! That wasn't a valid option. Try again.");
            }
        }

        sc.close();
    }

    // ===== Basic Arithmetic =====
    public static void basicArithmetic(Scanner sc) {
        System.out.print("Enter the first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double b = sc.nextDouble();

        System.out.print("Choose operation (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        double result;

        switch (operator) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                if (b == 0) {
                    System.out.println("Error: You can't divide by zero.");
                    return;
                }
                result = a / b;
            }
            default -> {
                System.out.println("Invalid operator. Please choose from +, -, *, /.");
                return;
            }
        }

        System.out.println("Result: " + result);
    }

    // ===== Scientific Calculations =====
    public static void scientificCalculations(Scanner sc) {
        System.out.println("\nChoose a scientific operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation (a raised to the power b)");

        System.out.print("Enter your choice: ");
        int option = sc.nextInt();

        switch (option) {
            case 1 -> {
                System.out.print("Enter a number: ");
                double num = sc.nextDouble();
                if (num < 0) {
                    System.out.println("Square root of a negative number isn't real. Try again.");
                    return;
                }
                System.out.println("Square root: " + Math.sqrt(num));
            }
            case 2 -> {
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter exponent: ");
                double exponent = sc.nextDouble();
                System.out.println("Result: " + Math.pow(base, exponent));
            }
            default -> System.out.println("Invalid choice for scientific calculation.");
        }
    }

    // ===== Unit Conversions =====
    public static void unitConversions(Scanner sc) {
        System.out.println("\nWhich conversion do you need?");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. INR to USD");
        System.out.println("4. USD to INR");

        System.out.print("Pick an option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1 -> {
                System.out.print("Enter temperature in Celsius: ");
                double celsius = sc.nextDouble();
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.println("Temperature in Fahrenheit: " + fahrenheit);
            }
            case 2 -> {
                System.out.print("Enter temperature in Fahrenheit: ");
                double fahrenheit = sc.nextDouble();
                double celsius = (fahrenheit - 32) * 5 / 9;
                System.out.println("Temperature in Celsius: " + celsius);
            }
            case 3 -> {
                System.out.print("Enter amount in INR: ");
                double inr = sc.nextDouble();
                double usd = inr / 83.0; // example conversion rate
                System.out.println("Amount in USD: " + usd);
            }
            case 4 -> {
                System.out.print("Enter amount in USD: ");
                double usd = sc.nextDouble();
                double inr = usd * 83.0; // example conversion rate
                System.out.println("Amount in INR: " + inr);
            }
            default -> System.out.println("That conversion option doesn't exist. Try again.");
        }
    }
}
