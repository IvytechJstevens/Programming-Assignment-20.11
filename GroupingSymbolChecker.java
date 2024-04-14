import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class GroupingSymbolChecker {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GroupingSymbolChecker <filename>");
            return;
        }
        
        String filename = args[0];
        if (!filename.endsWith(".java")) {
            System.out.println("Please provide a Java source-code file.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Stack<Character> stack = new Stack<>();
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                for (char c : line.toCharArray()) {
                    if (c == '(' || c == '{' || c == '[') {
                        stack.push(c);
                    } else if (c == ')' || c == '}' || c == ']') {
                        if (stack.isEmpty()) {
                            System.out.println("Error: Extra closing symbol at line " + lineNumber);
                            return;
                        }
                        char top = stack.pop();
                        if (!((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']'))) {
                            System.out.println("Error: Mismatched symbols at line " + lineNumber);
                            return;
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                System.out.println("Error: Unclosed grouping symbol(s)");
            } else {
                System.out.println("No errors found. Grouping symbols are balanced.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
