import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static Character[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new Character[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (arr[i][j] == '-') {
                        dfs(i, j);
                        count++;
                    } else {
                        dfs1(i, j);
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        int nx = x + 0;
        int ny = y + 1;

        if (ny >= 0 && ny < m && arr[nx][ny] == '-' && !visited[nx][ny]) {
            dfs(nx, ny);
        }
    }

    private static void dfs1(int x, int y) {
        visited[x][y] = true;

        int nx = x + 1;
        int ny = y + 0;

        if (nx >= 0 && nx < n && arr[nx][ny] == '|' && !visited[nx][ny]) {
            dfs1(nx, ny);
        }
    }
}
