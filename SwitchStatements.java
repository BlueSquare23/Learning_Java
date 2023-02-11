import java.util.Scanner;

class SwitchStatments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example Simple Calculator

        System.out.print("Enter first number: ");
        Double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        Double num2 = scanner.nextDouble();

        // Cleanup input buffer
        scanner.nextLine();

        System.out.print("What operation would you like to preform? (+,-,*,/): ");
        String opt = scanner.nextLine();

        switch (opt) {
            case "+":
                System.out.printf("%f + %f = %f\n", num1, num2, num1 + num2);
                break;
            case "-":
                System.out.printf("%f - %f = %f\n", num1, num2, num1 - num2);
                break;
            case "*":
                System.out.printf("%f * %f = %f\n", num1, num2, num1 * num2);
                break;
            case "/":
                System.out.printf("%f / %f = %f\n", num1, num2, num1 / num2);
                break;
            default:
                System.out.println("Invalid Operation!");
        }

        scanner.close();
    }
}
