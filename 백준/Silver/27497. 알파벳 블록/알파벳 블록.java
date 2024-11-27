import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());

            if (input == 1) {
                char ch = st.nextToken().charAt(0);
                deque.addLast(ch);  // 뒤에 추가
                stack.push(1);
            } else if (input == 2) {
                char ch = st.nextToken().charAt(0);
                deque.addFirst(ch);  // 앞에 추가
                stack.push(2);
            } else {  // input == 3
                if (!stack.isEmpty()) {
                    int lastCommand = stack.pop();
                    if (lastCommand == 1 && !deque.isEmpty()) {
                        deque.pollLast();  // 뒤에서 삭제
                    } else if (lastCommand == 2 && !deque.isEmpty()) {
                        deque.pollFirst();  // 앞에서 삭제
                    }
                }
            }
        }

        if (deque.isEmpty()) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            for (char ch : deque) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}
