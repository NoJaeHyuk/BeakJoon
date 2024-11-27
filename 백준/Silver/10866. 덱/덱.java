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

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (deque.isEmpty() && !command.equals("size")) {
                if (command.equals("pop_front") || command.equals("pop_back") || command.equals("front")
                    || command.equals("back")) {
                    System.out.println(-1);
                    continue;
                } else if (command.equals("empty")) {
                    System.out.println(1);
                    continue;
                }
            }

            if (command.equals("push_front")) {
                deque.addFirst(st.nextToken());
            } else if (command.equals("push_back")) {
                deque.addLast(st.nextToken());
            } else if (command.equals("pop_front")) {
                System.out.println(deque.pollFirst());
            } else if (command.equals("pop_back")) {
                System.out.println(deque.pollLast());
            } else if (command.equals("size")) {
                System.out.println(deque.size());
            } else if (command.equals("empty")) {
                System.out.println(0);
            } else if (command.equals("front")) {
                System.out.println(deque.peekFirst());
            } else if (command.equals("back")) {
                System.out.println(deque.peekLast());
            }
        }
    }
}
