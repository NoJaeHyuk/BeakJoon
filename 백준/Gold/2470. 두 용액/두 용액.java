import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int target = Integer.MAX_VALUE;

        int result1 = 0;
        int result2 = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];
            
            if(sum == 0) {
                System.out.println(arr[start] + " " + arr[end]);
                return;
            }

            if (Math.abs(sum) < Math.abs(target)) {
                target = sum;
                // 이 순간이 조건에 맞는 경우이다.
                result1 = arr[start];
                result2 = arr[end];
            }

            if(sum < 0) {
                start++; //음수 값이 크니까 왼쪽 포인터를 옮겨준다
            }
            else {
                end--; //양수 값이 크니까 오른쪽 포인터를 옮겨준다.
            }
        }

        System.out.println(result1 + " " + result2);
    }
}
