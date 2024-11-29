import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < k -1; i++) {
                queue.add(queue.poll());
            }
            result.append(queue.poll()); // K번째 숫자 제거
            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }
        result.append(">");
        System.out.println(result);
    }
}
