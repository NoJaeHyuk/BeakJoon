import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> countSet = new HashMap<>();
        
        // 참가자 명단을 해시맵에 저장하면서 카운트
        for (String str : participant) {
            countSet.put(str, countSet.getOrDefault(str, 0) + 1);
        }
        
        // 완주자 명단을 순회하며 카운트를 감소
        for (String com : completion) {
            countSet.put(com, countSet.get(com) - 1);
        }
        
        // 카운트가 0이 아닌 키가 완주하지 못한 선수
        for (Map.Entry<String, Integer> entry : countSet.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        
        return ""; // 모든 참가자가 완주한 경우 빈 문자열 반환 (문제 조건에선 발생하지 않음)
    }
}