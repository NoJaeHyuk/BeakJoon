import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (start == end) {
            System.out.println(0);
            return;
        }

        int[] dx = {-1, 1, 2};
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); // 시작위치와 초
        visited[start] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int location = current[0];
            int time = current[1];

            for (int i = 0; i < 3; i++) {
                int nx = location;
                if (i == 2) {
                    nx = nx * 2;
                } else {
                    nx = location + dx[i];
                }

                if (nx >= 0 && nx < 100001 && visited[nx] == -1) {
                    visited[nx] = time + 1;
                    if (nx == end) {
                        System.out.println(time + 1);
                        return; // BFS 조기 종료
                    }
                    queue.add(new int[]{nx, time + 1});
                }
            }
        }
    }
}
