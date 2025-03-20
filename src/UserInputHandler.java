import java.util.Scanner;

public class UserInputHandler {
    private final Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Будь ласка, введіть число!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Будь ласка, введіть число з десятковою крапкою!");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String getStringInput() {
        return scanner.nextLine().trim();
    }

    public void closeScanner() {
        scanner.close();
    }
}
