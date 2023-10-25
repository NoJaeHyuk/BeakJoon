import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        
        for(int ix : arr){
            if(!list.contains(ix)){
                list.add(ix);
            }
            
            if(list.size() >= k){
                break;
            }
        }
        
        if(list.size() < k){
            for(int i = list.size(); i < k; i++){
                list.add(-1);
            }
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}