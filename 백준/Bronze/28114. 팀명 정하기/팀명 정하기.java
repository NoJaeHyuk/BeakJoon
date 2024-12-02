import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] years = new int[3];
        int[][] solve = new int[3][2];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            solve[i][0] = Integer.parseInt(st.nextToken());
            years[i] = Integer.parseInt(st.nextToken()) % 100;
            solve[i][1] = st.nextToken().charAt(0);
        }

        // 학변 오름 차순
        Arrays.sort(years);

        // 푼 문제기준 내림차순
        Arrays.sort(solve, (o1, o2) -> o2[0] - o1[0]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            System.out.print(years[i]);
            sb.append((char)solve[i][1]);
        }

        System.out.println("\n" + sb);
    }
}
