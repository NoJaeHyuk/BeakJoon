import java.util.HashMap;
import java.util.Map;

class Solution {
     public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> countMap = new HashMap<>();

        for(int i = 0; i < want.length; i++){
            countMap.put(want[i], number[i]);
        }

        for(int i = 0; i < (discount.length - 10)+1; i++){
            Map<String, Integer> checkMap = new HashMap<>();
            for(int j = i;  j < (i+10); j++){
                checkMap.put(discount[j], checkMap.getOrDefault(discount[j],0)+1);
            }

            Boolean isIdentical = true;

            for(String key : countMap.keySet()){
                if(countMap.get(key) != checkMap.get(key)){
                    isIdentical = false;
                    break;
                }
            }

            answer += isIdentical ? 1 : 0;
        }

        System.out.println(answer);
        return answer;
    }
}