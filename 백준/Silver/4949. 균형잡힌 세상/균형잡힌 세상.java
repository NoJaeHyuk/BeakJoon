import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String text = br.readLine();
            if (text.equals(".")) {
                return;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (char ch : text.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']') {
                    /*if (stack.isEmpty()) {
                        break;
                    }
                    char peek = stack.peek();
                    if (ch == ')' && peek == '(') {
                        stack.pop();
                    } else if (ch == ']' && peek == '[') stack.pop();*/
                    if (stack.isEmpty() || (ch == ')' && stack.pop() != '(') || (ch == ']' && stack.pop() != '[')) {
                        isBalanced = false;
                        break;
                    }
                }
            }

            // 최종 결과 출력
            System.out.println(isBalanced && stack.isEmpty() ? "yes" : "no");
        }
    }
}
