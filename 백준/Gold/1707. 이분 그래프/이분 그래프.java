import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] colors;
    static List<ArrayList<Integer>> graphs;
    static boolean checkBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graphs = new ArrayList<>();
            for (int j = 0; j < V + 1; j++) {
                graphs.add(new ArrayList<Integer>());
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                // 양방향 그래프 연결
                graphs.get(u).add(v);
                graphs.get(v).add(u);
            }

            colors = new int[V + 1];
            checkBipartite = true;
            for (int j = 0; j < V + 1; j++) {
                if (!checkBipartite) {
                    break;
                }

                if (colors[j] == 0) {
                    bfs(j);
                }
            }

            System.out.println(checkBipartite ? "YES" : "NO");
        }
    }

    private static void bfs(int startV) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startV);
        colors[startV] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int adjV : graphs.get(current)) {
                if (colors[adjV] == 0) {
                    queue.offer(adjV); // 인접 정점을 큐에 삽입
                    colors[adjV] = colors[current] * -1;
                } else if (colors[adjV] + colors[current] != 0) {
                    checkBipartite = false;
                    return;
                }
            }
        }
    }
}
