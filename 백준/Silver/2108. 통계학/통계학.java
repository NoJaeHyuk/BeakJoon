import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 데이터 입력 및 초기화
        int[] numbers = new int[n];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
            total += num;
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 데이터 정렬
        Arrays.sort(numbers);

        // 결과 계산
        int mean = calculateMean(total, n);
        int median = calculateMedian(numbers);
        int mode = calculateMode(frequencyMap);
        int range = calculateRange(numbers);

        // 결과 출력
        printResults(mean, median, mode, range);
    }

    private static int calculateMean(double total, int n) {
        return (int) Math.round(total / n);
    }

    private static int calculateMedian(int[] numbers) {
        return numbers[numbers.length / 2];
    }

    private static int calculateMode(Map<Integer, Integer> frequencyMap) {
        int maxFrequency = Collections.max(frequencyMap.values());
        List<Integer> candidates = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                candidates.add(entry.getKey());
            }
        }

        Collections.sort(candidates);
        return candidates.size() == 1 ? candidates.get(0) : candidates.get(1);
    }

    private static int calculateRange(int[] numbers) {
        return numbers[numbers.length - 1] - numbers[0];
    }

    private static void printResults(int mean, int median, int mode, int range) {
        StringBuilder sb = new StringBuilder();
        sb.append(mean).append("\n");
        sb.append(median).append("\n");
        sb.append(mode).append("\n");
        sb.append(range).append("\n");
        System.out.println(sb);
    }
}
