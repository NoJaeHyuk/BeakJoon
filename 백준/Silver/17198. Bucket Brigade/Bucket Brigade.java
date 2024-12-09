import java.io.*;
import java.util.*;

public class Main {
    static char[][] grid = new char[10][10]; // 격자
    static boolean[][] visited = new boolean[10][10]; // 방문 여부
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int startX = 0, startY = 0, endX = 0, endY = 0;
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'L') { // 호수 위치
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'B') { // 헛간 위치
                    endX = i;
                    endY = j;
                }
            }
        }

        // BFS 탐색 시작
        int result = bfs(startX, startY, endX, endY);

        // 결과 출력
        System.out.println(result);
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0}); // {현재 x, 현재 y, 이동 거리}
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 헛간에 도착한 경우
            if (x == endX && y == endY) {
                return distance - 1; // 호수와 헛간 제외한 칸 수
            }

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (isValid(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return -1; // 경로가 없는 경우
    }

    static boolean isValid(int x, int y) {
        // 격자 범위 내 && 방문하지 않았고 && 장애물이 아닌 경우
        return x >= 0 && x < 10 && y >= 0 && y < 10 && !visited[x][y] && grid[x][y] != 'R';
    }
}
