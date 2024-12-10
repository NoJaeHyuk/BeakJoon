import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double total = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            total += input;
            countMap.put(input, countMap.getOrDefault(input, 0) + 1);
        }

        Arrays.sort(arr);
        int minIndex = (0 + arr.length - 1) / 2;

        // 출력값
        StringBuilder sb = new StringBuilder();
        sb.append((int)Math.round(total / n)).append("\n");
        sb.append(arr[minIndex]).append("\n");
        sb.append(findFrequence(countMap)).append("\n");
        sb.append(arr[arr.length - 1] - arr[0]).append("\n");

        System.out.println(sb);
    }

    private static int findFrequence(Map<Integer, Integer> countMap) {
        int max = Collections.max(countMap.values()); // 가장 빈번하게 호출되는 값

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);

        if (list.size() == 1) {
            return list.get(0);
        } else {
            return list.get(1);
        }
    }
}
