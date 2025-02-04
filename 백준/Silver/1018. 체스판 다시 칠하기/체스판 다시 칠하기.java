import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int SIZE = 8;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String ary = br.readLine();
            for (int j = 0; j < M; j++) {
                if (ary.charAt(j) == 'B') {
                    board[i][j] = true;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        // 모든 8x8을 탐색할 수 있는 조건
        for (int i = 0; i + SIZE <= N; i++) {
            for (int j = 0; j + SIZE <= M; j++) {
                // 체크판을 칠하는 조건 카운터
                min = Math.min(min, countChangedColor(i , j));
            }
        }

        System.out.println(min);
    }

    private static int countChangedColor(int r_start, int c_start) {
        int r_end = r_start + SIZE;
        int c_end = c_start + SIZE;

        boolean firstColor = board[r_start][c_start];
        int count = 0;

        for (int i = r_start; i < r_end; i++) {
            boolean color = firstColor;

            for (int j = c_start; j < c_end; j++) {
                if (board[i][j] != color) {
                    count++;
                }
                color = !color;
            }

            firstColor = !firstColor;
        }

        return Math.min(count, (SIZE * SIZE) - count);
    }
}
