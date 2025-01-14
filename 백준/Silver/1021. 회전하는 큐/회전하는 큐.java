import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 회전하는 큐
 * https://www.acmicpc.net/problem/1021
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 두 개의 정수 읽기
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 두 번째 줄에서 세 개의 정수 읽기
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = scanner.nextInt();
        }

        LinkedList<Integer> deque = new LinkedList();
        IntStream.range(1, n + 1).forEach((x) -> deque.add(x));

        int count = 0;

        for (int num : array) {
            int half_idx;
            if (deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            } else {
                half_idx = deque.size() / 2;
            }
            
            while (deque.peek() != num) {
                if (deque.indexOf(num) <= half_idx) {
                    Integer pollFirst = deque.pollFirst();
                    deque.add(pollFirst);
                    count++;
                }else {
                    Integer pollLast = deque.pollLast();
                    deque.add(0, pollLast);
                    count++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}
