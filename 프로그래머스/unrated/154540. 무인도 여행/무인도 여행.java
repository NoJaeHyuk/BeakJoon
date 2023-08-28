import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] maps_1;
    
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        maps_1 = new char[maps.length][maps[0].length()];
        visited = new boolean[maps_1.length][maps_1[0].length];
        
        for (int i = 0; i < maps.length; i++) {
            maps_1[i] = maps[i].toCharArray();
        }
        
        for(int i = 0; i < maps_1.length; i++){
            for(int j = 0; j < maps_1[i].length; j++){
                if(maps_1[i][j] != 'X' && !visited[i][j]){
                    answer.add(BFS(i,j));        
                }
            }
        }
        
        if(answer.size() == 0){
            answer.add(-1);
        }else{
            Collections.sort(answer);
        }
        
        return answer;
    }
    
    public static int BFS(int i, int j){
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            sum += maps_1[cx][cy]-'0';
            
            for(int k = 0; k < dx.length; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                
                if(nx < 0 || ny < 0 || nx >= maps_1.length || ny >= maps_1[0].length){
                    continue;
                }
                
                if(maps_1[nx][ny] != 'X' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        
        return sum;
    }
}