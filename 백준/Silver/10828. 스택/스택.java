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
            String[] commands = br.readLine().split(" ");

            if (commands[0].equals("push")) {
                stack.push(Integer.valueOf(commands[1]));
            } else {
                stackPrint(commands[0], stack);
            }
        }
    }

    public static void stackPrint(String command, Stack stack){
        if (command.equals("pop")) {
            if (stack.empty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(stack.pop());
        } else if (command.equals("size")) {
            System.out.println(stack.size());
        } else if (command.equals("empty")) {
            if (stack.empty()) {
                System.out.println(1);
                return;
            }
            System.out.println(0);
        } else if (command.equals("top")) {
            if (stack.empty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(stack.peek());
        }
    }


}
