import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> countSet = new HashMap<>();
        
        for (String str : participant) {
            countSet.put(str, countSet.getOrDefault(str, 0) + 1);
        }
        
        for (String com : completion) {
            countSet.put(com, countSet.getOrDefault(com, 0) - 1);
            if(countSet.get(com) == 0){
                countSet.remove(com);
            }
        }
        
        for (String key : countSet.keySet()) {
            answer = key;
        }
        
        return answer;
    }
}