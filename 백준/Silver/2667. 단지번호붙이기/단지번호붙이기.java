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
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        List<Integer> arr = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                    arr.add(sum);
                    sum = 0;
                }
            }
        }

        System.out.println(count);
        Collections.sort(arr);
        for (Integer a : arr) {
            System.out.println(a);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        sum++;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == '1') {
                dfs(nx, ny);
            }
        }
    }
}
