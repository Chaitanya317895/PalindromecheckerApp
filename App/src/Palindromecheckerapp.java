import java.util.*;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray())
            stack.push(c);
        for (char c : input.toCharArray())
            if (c != stack.pop())
                return false;
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray())
            deque.addLast(c);
        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;
        return true;
    }
}

class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }
}

public class Palindromecheckerapp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeContext context = new PalindromeContext(new StackStrategy());

        boolean result = context.execute(input);

        if (result)
            System.out.println("The string is a Palindrome");
        else
            System.out.println("The string is NOT a Palindrome");

        sc.close();
    }
}