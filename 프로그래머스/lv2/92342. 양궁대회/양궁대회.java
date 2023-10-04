import java.util.*;

class Solution {
    static ArrayList<int[]> list = new ArrayList<int[]>();
    static int max_diff = Integer.MIN_VALUE;
    static int[] ryan;
    static int[] apeach;
    
    public int[] solution(int n, int[] info) {
        int[] answer = {-1};
        ryan = new int[11];
        apeach = info;
        
        DFS(0, n, 0);
        if(max_diff == Integer.MIN_VALUE) return new int[]{-1};
        
        Collections.sort(list, (o1, o2) -> {
            for(int i = 10; i >= 0; i--){
                if(o1[i] != o2[i]){
                    return o2[i] - o1[i];
                }
            }
            return 0;
        });
        
        return list.get(0);
    }
    
    public void DFS(int L, int n, int start){
        if(L == n){
            int a_sum = 0;
            int r_sum = 0;
                
            for(int i = 0; i < 10; i++){
                if(apeach[i] == 0 && ryan[i] == 0) continue;
                if(apeach[i] >= ryan[i]){
                    a_sum += (10-i);
                }else{
                    r_sum += (10-i);
                }
            } 
            
            if(r_sum > a_sum){
                int diff = r_sum - a_sum;
                if(max_diff < diff){
                    max_diff = diff;
                    list.clear();
                    list.add(ryan.clone());
                } else if(max_diff == diff){
                    list.add(ryan.clone());
                }
            }
            
            return;
        }else{
            for(int i = start; i < 11; i++){
                ryan[i]++;
                DFS(L+1, n, i);   
                ryan[i]--;
            }
        }
    }
}