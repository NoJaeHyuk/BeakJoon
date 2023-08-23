import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer,Integer> countMap = new HashMap<>();

        for(int e : tangerine){
            countMap.put(e,countMap.getOrDefault(e,0)+1);
        }

        List<Integer> keylist = new ArrayList<>(countMap.keySet());
        //큰 수로 정렬하여 푼다.
        Collections.sort(keylist, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o2)-countMap.get(o1);
            }
        });

        for(Integer i : keylist){
            if(k <= 0){
                break;
            }
            answer++;
            k -= countMap.get(i);
        }
        return answer;
    }
}