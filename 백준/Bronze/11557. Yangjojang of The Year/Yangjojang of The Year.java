import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int maxCount = 0;
            String maxName = "";
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String schoolName = st.nextToken();// 학교명
                int alcoholCount = Integer.parseInt(st.nextToken()); // 마신 술량

                if (maxCount < alcoholCount) {
                    maxName = schoolName;
                    maxCount = alcoholCount;
                }
            }
            sb.append(maxName + "\n");
        }

        System.out.println(sb);
    }
}
