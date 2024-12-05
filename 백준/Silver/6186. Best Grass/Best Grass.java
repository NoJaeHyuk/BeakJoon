import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Character[][] arr = new Character[R][C];
        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // 상하좌우 이동을 위한 dx, dy 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int grassCount = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '#' && !visited[i][j]) {
                    dfs(i, j, arr, visited, dx, dy, R, C);
                    grassCount++;
                }
            }
        }

        System.out.println(grassCount);
    }

    // DFS 메서드
    private static void dfs(int x, int y, Character[][] arr, boolean[][] visited, int[] dx, int[] dy, int R, int C) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 배열 범위를 벗어나지 않고, 방문하지 않았으며, '#'인 경우
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] == '#' && !visited[nx][ny]) {
                dfs(nx, ny, arr, visited, dx, dy, R, C);
            }
        }
    }
}
