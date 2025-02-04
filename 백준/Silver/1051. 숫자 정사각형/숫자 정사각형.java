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

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }


        int maxSize = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 가능한 한 변의 길이 증가시키면서 검사
                for (int k = 1; (i + k < N) && (j + k < M); k++) {
                    // 네 꼭짓점이 같은지 확인
                    if (board[i][j] == board[i + k][j] &&
                            board[i][j] == board[i][j + k] &&
                            board[i][j] == board[i + k][j + k]) {

                        maxSize = Math.max(maxSize, k + 1); // k+1이 실제 변의 길이
                    }
                }
            }
        }

        System.out.println(maxSize * maxSize);
    }
}
