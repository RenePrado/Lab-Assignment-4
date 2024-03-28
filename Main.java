import java.util.Scanner;

public class Main {
    private static final String validPassword = "password";
    private static final int maxLoginTries = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loginTries = 0;

        while (loginTries < maxLoginTries) {
            try {
                System.out.print("Enter Username: ");
                String username = scanner.nextLine();

                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                System.out.println();

                if (!password.equals(validPassword)) {
                    throw new InvalidPasswordException("Invalid Password!");
                }

                System.out.println("Login Successful! Welcome, " + username + "!");
                break;

            } catch (InvalidPasswordException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println();
                loginTries++;

                if (loginTries == maxLoginTries) {
                    System.out.println("Maximum Login Attempts Exceeded!");
                    break;
                }
            }
        }
        scanner.close();
    }
}
