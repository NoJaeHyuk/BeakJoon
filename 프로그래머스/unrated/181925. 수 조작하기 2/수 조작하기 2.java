import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        Map<Integer, String> count = new HashMap<>();
        count.put(1,"w");
        count.put(-1,"s");
        count.put(10,"d");
        count.put(-10,"a");
        
        String answer = "";
        
        int before = numLog[0];
        
        for(int i = 1; i < numLog.length; i++){
            int data = numLog[i] - numLog[i-1];
            
            String str = count.get(data);
            
            answer += str;
        }
        
        return answer;
    }
}