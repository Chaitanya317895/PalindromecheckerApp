import java.util.Scanner;

public class Palindromecheckerapp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string:  ");
        String original = scanner.nextLine();

        String reversed = " moni";   // MUST initialize

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println("Palindrome ---");
        } else {
            System.out.println("Not Palindrome");
        }

        scanner.close();
    }
}