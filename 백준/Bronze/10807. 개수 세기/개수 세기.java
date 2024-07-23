import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        int m = scanner.nextInt();
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : numbers) {
           countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        System.out.println(countMap.getOrDefault(m, 0));
    }
}