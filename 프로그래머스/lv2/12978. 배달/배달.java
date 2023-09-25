import java.util.*;

class Solution {
    static List<Edge>[] list;
    static int[] distance;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        list = new ArrayList[N+1];
        distance = new int[N+1];
        
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < road.length; i++){
            list[road[i][0]].add(new Edge(road[i][1],road[i][2]));
            list[road[i][1]].add(new Edge(road[i][0],road[i][2]));
        }
        
        dijkstra();
        
        for(int dis : distance){
            System.out.println(dis);
            if(dis <= K){
                System.out.println(222);
                answer++;
            }
        }

        return answer;
    }
    
    
    private static void dijkstra(){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        distance[1] = 0;
        queue.add(new Edge(1, 0));
        
        while(!queue.isEmpty()){
            Edge cur = queue.poll();
            int vertex = cur.v;
            int weight = cur.weight;
            
            if (distance[vertex] < weight) {
                continue;
            }
            
            for(int i = 0; i < list[vertex].size(); i++){
                int nv = list[vertex].get(i).v; 
                int nw = list[vertex].get(i).weight + weight;
                
                if(nw < distance[nv]){
                    distance[nv] = nw;
                    queue.add(new Edge(nv, nw));
                }
            }
        }
    }
    
    static class Edge implements Comparable<Edge>{
        private int v;
        private int weight;
        
        Edge(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
}