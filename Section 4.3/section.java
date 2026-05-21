import java.util.Arrays;

public class section {

    public static void main(String[] args) {
        // StackOfStrings5();
        // Reverse();
        // System.out.println(Arrays.toString(ReadDoubles()));
        // System.out.println(Parentheses("[()]{}{[()()]()}"));
        // toFullParentheses("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
        // InfixToPostfix("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )");
        // EvaluatePostfix("1 2 + 3 4 - 5 6 - * *");
        // find();
        // delete();
        // removeAfter();
        // copy();
        // System.out.println(EvaluateBoolean("( ( NOT ( true AND false ) ) OR false )"));
        printTruthTable("( ( NOT ( ( p1 AND p2 ) OR ( p3 AND p4 ) ) ) OR ( ( p5 AND ( NOT p6 ) ) AND ( ( p7 OR p8 ) AND ( NOT ( p9 OR p10 ) ) ) ) )");
    }

    // S6
    public static void printTruthTable(String input) {
        int numVars = 0;
        for (String part : input.split(" ")) {
            if (part.startsWith("p")) numVars++;
        }

        boolean[] results = new boolean[1 << numVars];
        for (int i = 0; i < results.length; i++) {
            String tempInput = input;
            for (int j = 0; j < numVars; j++) {
                String variable = "p" + (j + 1);
                boolean value = (i & (1 << j)) != 0;
                tempInput = replaceVariable(tempInput, variable, value);
            }
            results[i] = EvaluateBoolean(tempInput);
        }

        int[] colWidths = new int[numVars + 1];
        for (int i = 0; i < numVars; i++)
            colWidths[i] = 4 + ("p" + (i + 1)).length(); 
        colWidths[numVars] = 4 + input.length();      

        int totalWidth = 1;
        for (int w : colWidths) totalWidth += w + 1;

        System.out.print("|");
        for (int i = 0; i < numVars; i++)
            System.out.print("  " + "p" + (i + 1) + "  |");
        System.out.println("  " + input + "  |");

        System.out.print("|");
        for (int i = 0; i < totalWidth - 2; i++) System.out.print("-");
        System.out.println("|");

        for (int i = 0; i < results.length; i++) {
            System.out.print("|");

            for (int j = 0; j < numVars; j++) {
                boolean value = (i & (1 << j)) != 0;
                printCentered(value ? "T" : "F", colWidths[j]);
                System.out.print("|");
            }

            printCentered(results[i] ? "T" : "F", colWidths[numVars]);
            System.out.println("|");
        }

        System.out.print("|");
        for (int i = 0; i < totalWidth - 2; i++) System.out.print("-");
        System.out.println("|");
    }

    private static void printCentered(String text, int width) {
        int totalPad = width - text.length();
        int left  = totalPad / 2;
        int right = totalPad - left;
        for (int k = 0; k < left;  k++) System.out.print(" ");
        System.out.print(text);
        for (int k = 0; k < right; k++) System.out.print(" ");
    }

    private static String replaceVariable(String input, String variable, boolean value) {
        return input.replaceAll(variable + "(?!\\d)", String.valueOf(value));
    }

    // S5
    public static boolean EvaluateBoolean(String input) {
        Stack<String> ops = new Stack<>();
        Stack<Boolean> vals = new Stack<>();
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            switch (token) {
                case ")" -> {
                    String op = ops.pop();
                    boolean val;
                    val = switch (op) {
                        case "AND" -> vals.pop() && vals.pop();
                        case "OR" -> vals.pop() || vals.pop();
                        case "NOT" -> !vals.pop();
                        default -> false;
                    };

                    vals.push(val); 
                }
                case "AND", "OR", "NOT" -> ops.push(token);
                case "true", "false" -> vals.push(Boolean.valueOf(token));
                default -> {}
            }
        }

        return vals.pop();
    }

    // S4
    // 2 + 3 * 4                         = 3 4 * 2 +
    // (2 + 3) * 4                       = 2 3 + 4 *
    // (6 + 2 / 3^2) / (13 -  2^3 / 5^3) = 2 3 2 pow / 6 + 13 2 3 pow 5 3 pow / - /

    // S3
    // A Stack because you would pop off the most recent action, not the oldest

    // S2
    // FILO = First In Last Out = Stack
    // LILO = Last In Last Out = Queue

    // S1
    // A Pez desperencer is a Stack

    // 4.3.27
    // When it comes time to update t.next, x.next is no longer the original
    //    node following x, but is instead t itself!

    // 4.3.26
    // Inserts node t immediately after node x.

    // 4.3.23
    // Deletes from the list the node immediately following x.

    /* 4.3.16
    a. 0 1 2 3 4 5 6 7 8 9 // Possible
    b. 4 6 8 7 5 3 2 9 0 1 // Not Possible  
    c. 2 5 6 7 4 8 9 3 1 0 // Not Possible
    d. 4 3 2 1 0 5 6 7 8 9 // Not Possible
    */

    // 4.3.15
    public static void EvaluatePostfix(String input) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(evaluate(first, second, token));
            } else {
                stack.push(Double.valueOf(token));
            }
        }

        System.out.println(stack.pop());
    }

    private static double evaluate(double first, double second, String operator) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0.0;
        };
    }

    // 4.3.14
    public static void InfixToPostfix(String input) {
        Stack<String> stack = new Stack<>();
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (token.equals("(")) {
                // Do nothing
            } else if (token.equals(")")) {
                System.out.print(stack.pop() + " ");
            } else if (isOperator(token)) {
                stack.push(token);
            } else {
                System.out.print(token + " ");
            }
        }

        System.out.println();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // 4.3.13
    public static void toFullParentheses(String input) {
        Stack<String> stack = new Stack<>();
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (token.equals(")")) {
                String second = stack.pop();
                String operator = stack.pop();
                String first = stack.pop();
                stack.push("(" + first + " " + operator + " " + second + ")");
            } else {
                stack.push(token);
            }
        }

        System.out.println(stack.pop());
    }

    // 4.3.11
    // Already implemented

    // 4.3.9
    // Already implemented

    // 4.3.8
    // This code fragment reverses the order of all elements in the queue.

    // 4.3.7 
    // Prints the binary representation of n (110010 when n is 50).    

    // 4.3.6
    public static boolean Parentheses(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (isClosed(input.charAt(i))) {
                if (stack.isEmpty() || !matchingOpen(stack.peek(), input.charAt(i)))
                    return false;
                else
                    stack.pop();
            } else {
                stack.push(input.charAt(i));
            }
        }

        return stack.size() == 0;
    }

    private static boolean isClosed(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean matchingOpen(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}');
    }

    // 4.3.5
    public static double[] ReadDoubles() {
        Queue<Double> queue = new Queue<>();

        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readDouble());
        }

        double[] arr = new double[queue.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.dequeue();
        }

        return arr;
    }

    // 4.3.4
    public static void Reverse() {
        Stack<String> stack = new Stack<>();

        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readString());
        }

        while (!stack.isEmpty()) {
            StdOut.println(stack.pop());
        }
    }

    /* 4.3.3
    a. 4 3 2 1 0 9 8 7 6 5 // Possible
    b. 4 6 8 7 5 3 2 9 0 1 // Not Possible
    c. 2 5 6 7 4 8 9 3 1 0 // Possible
    d. 4 3 2 1 0 5 6 7 8 9 // Possible
    e. 1 2 3 4 5 6 9 8 7 0 // Possible
    f. 0 4 6 5 3 8 1 7 2 9 // Not Possible
    g. 1 4 7 9 8 6 5 3 0 2 // Not Possible
    h. 2 1 4 3 6 5 8 7 9 0 // Possible
    */

    // 4.3.2
    public static void StackOfStrings5() {
        Stack<String> stack = new Stack<>();
        stack.push("it");
        stack.push("was");
        System.out.println(stack.pop());
        stack.push("the");
        stack.push("best");
        System.out.println(stack.pop());
        stack.push("of");
        stack.push("times");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("it");
        stack.push("was");
        System.out.println(stack.pop());
        stack.push("the");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}