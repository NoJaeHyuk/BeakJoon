import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 첫 번째 수첩 크기
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> note1 = new HashSet<>();

            // 첫 번째 수첩 숫자 저장
            for (int i = 0; i < N; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine()); // 두 번째 수첩 크기
            st = new StringTokenizer(br.readLine());

            // 두 번째 수첩 숫자 확인
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (note1.contains(num)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }
        System.out.print(sb);
    }
}
