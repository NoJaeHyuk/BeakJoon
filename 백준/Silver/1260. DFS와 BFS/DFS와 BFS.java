import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer> graph[];
    static boolean isVisited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 정렬
        for (int i = 0; i < N + 1; i++) Collections.sort(graph[i]);

        isVisited = new boolean[N + 1];
        DFS(V);
        System.out.println();

        isVisited = new boolean[N + 1];
        BFS(V);
    }

    static void DFS(int v) {
        if (isVisited[v] == false) { // 방문하지 않았다면 출력하고 방문 처리
            System.out.print(v + " ");
            isVisited[v] = true;
        }
        for (int i = 0; i < graph[v].size(); i++) { // 인접 노드 탐색
            if (isVisited[graph[v].get(i)]) continue;
            DFS(graph[v].get(i));
        }
    }

    static void BFS(int root) {
        Queue<Integer> que = new LinkedList<>();

        que.add(root); // 루트 노드 Enqueue
        isVisited[root] = true;

        while (!que.isEmpty()) {
            int node = que.poll(); // Dequeue
            System.out.print(node + " ");

            for (int i = 0; i < graph[node].size(); i++) { // 인접 노드 탐색
                if (isVisited[graph[node].get(i)] == true) continue;
                que.add(graph[node].get(i)); // 인접 노드 Enqueue
                isVisited[graph[node].get(i)] = true;
            }
        }
    }

}
