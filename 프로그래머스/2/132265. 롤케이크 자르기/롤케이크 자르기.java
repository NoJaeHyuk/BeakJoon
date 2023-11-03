import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> firstMap = new HashMap<>();
        
        for(Integer ix : topping){
            countMap.put(ix, countMap.getOrDefault(ix,0)+1);
        }
        
        
        for(int i = 0; i < topping.length; i++){
            firstMap.put(topping[i], firstMap.getOrDefault(topping[i], 0)+1);
            countMap.put(topping[i], countMap.get(topping[i])-1);
            
            if(countMap.get(topping[i]) <= 0){
                countMap.remove(topping[i]);
            }
            
            if(firstMap.size() == countMap.size()){
                answer++;
            }
        }
        
        
        return answer;
    }
}