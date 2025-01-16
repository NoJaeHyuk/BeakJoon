import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            // 시작인덱스의 경우 주어진 강의 값 중 가장 큰 값입니다.
            start = Math.max(start, A[i]);
            // 종료인덱스는 모든 강의의 합이 블루레이 하나에 다 포함되는 경우이다.
            end += A[i];
        }

        // 이분탐색
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0; // 블루레이 개수
            int sum = 0; // 한 블루레이에 들어가는 합계

            // N번 돌면서 mid값으로 만들 수 있는 count값을 계산한다.
            for (int i = 0; i < N; i++) {
                if (sum + A[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }

            // 마지막값에 대해 카운팅되지 않는 값이 존재한다는 이야기므로 count를 증가시킨다.
            if (sum > 0) {
                count++;
            }

            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
