import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }

        int count = 1;
        int top = stack.pop();

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (top < pop) {
                top = pop;
                count++;
            }
        }

        System.out.println(count);
    }
}
