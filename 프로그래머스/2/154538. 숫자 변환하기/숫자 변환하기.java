import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        // x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        
        for(int i = x; i < y+1; i++){
            if(dp[i] == Integer.MAX_VALUE){
                continue;
            }
            
            if(y >= i+n){
                dp[i+n] = Math.min(dp[i+n], dp[i]+1); 
            }
            
            if(y >= i*2){
                dp[i*2] = Math.min(dp[i*2], dp[i]+1);
            }
            
            if(y >= i*3){
                dp[i*3] = Math.min(dp[i*3], dp[i]+1);
            }
            
        }
        
        if(dp[y] == Integer.MAX_VALUE){
            dp[y] = -1;
        }

        return dp[y];
    }
}