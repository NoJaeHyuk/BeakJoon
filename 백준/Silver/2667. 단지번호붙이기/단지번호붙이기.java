import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        List<Integer> complexSizes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    int size = dfs(i, j);
                    complexSizes.add(size);
                }
            }
        }

        System.out.println(complexSizes.size());
        Collections.sort(complexSizes);
        for (Integer size : complexSizes) {
            System.out.println(size);
        }
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = 1;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == '1') {
                size += dfs(nx, ny);
            }
        }

        return size;
    }
}
