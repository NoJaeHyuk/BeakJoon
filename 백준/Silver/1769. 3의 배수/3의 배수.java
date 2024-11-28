import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine(); // 입력값을 String으로 읽음
        int transform = 0;

        while (x.length() > 1) { // 한 자리 숫자가 될 때까지 반복
            int sum = 0;
            transform++;
            for (char ch : x.toCharArray()) { // 각 자릿수 합산
                sum += ch - '0';
            }
            x = String.valueOf(sum); // 합계를 문자열로 변환
        }

        // 최종 출력
        System.out.println(transform);
        if (Integer.parseInt(x) % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
