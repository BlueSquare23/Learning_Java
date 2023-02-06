import java.util.Scanner;

class UserInput {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = scanner.nextLine();

        System.out.printf("Hello, %s!\n", name);

        System.out.print("How old are you? ");
        int age = scanner.nextInt();

        // Clears input buffer
        scanner.nextLine();

        System.out.printf("%d is an excellent age to start programming!\n", age);

        scanner.close();
    }
}
