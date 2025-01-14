import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                countMap.put(x, countMap.getOrDefault(x, 0) + 1);
            }

            int M = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int x = Integer.parseInt(st1.nextToken());
                if (countMap.containsKey(x)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
