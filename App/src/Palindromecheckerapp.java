import java.util.*;

public class Palindromecheckerapp {

    static boolean arrayMethod(String input) {
        char[] arr = input.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray())
            stack.push(c);

        for (char c : input.toCharArray())
            if (c != stack.pop())
                return false;

        return true;
    }

    static boolean dequeMethod(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start1 = System.nanoTime();
        boolean result1 = arrayMethod(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = stackMethod(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = dequeMethod(input);
        long end3 = System.nanoTime();

        System.out.println("Array Method Result: " + result1);
        System.out.println("Execution Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Method Result: " + result2);
        System.out.println("Execution Time: " + (end2 - start2) + " ns");

        System.out.println("Deque Method Result: " + result3);
        System.out.println("Execution Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}