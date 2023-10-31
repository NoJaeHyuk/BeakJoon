import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(String dirs) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 1);
        map.put('R', 2);
        map.put('L', 3);
        
        Set<String> count = new HashSet<>();
        
        int cx = 0;
        int cy = 0;
        int nx = 0;
        int ny = 0;
        
        for(char c : dirs.toCharArray()){
            int idx = map.get(c);
            
            nx = cx + dx[idx];
            ny = cy + dy[idx];
            
            if(nx > 5 || nx < -5 || ny > 5 || ny < -5) {
                continue;
            }
            
            if(idx == 0 || idx == 2){
                count.add(Arrays.toString(new int[]{cx, cy, nx, ny}));
            }else{
                count.add(Arrays.toString(new int[]{nx, ny, cx, cy}));
            }
            
            cx = nx;
            cy = ny;
        }
        
        return count.size();
    }
}