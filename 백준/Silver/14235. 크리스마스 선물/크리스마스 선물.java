import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        PriorityQueue queue = new PriorityQueue(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll());
                }else {
                    sb.append(-1);
                }
                sb.append("\n");
                continue;
            }

            for (int j = 0; j < a; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);
    }
}
