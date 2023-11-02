import java.util.*;

class Solution {
    static Map<String, Integer> ordersCount;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        // value 기준 내림차순 정렬하기 위해 사용
        // List<Character> keySet = new ArrayList<>(ordersCount.keySet());
        // keySet.sort((o1, o2) -> ordersCount.get(o2).compareTo(ordersCount.get(o1)));
        
        for(int n : course){
            // course의 갯수에 대한 카운터만 있는 countMap 만들기 위해
            ordersCount = new HashMap<>();
            
            for(String s : orders){
                //우선 알파벳으로 정렬
                char[] result = s.toCharArray();
                Arrays.sort(result);
                String str = new String(result);
                
                combi(str, new StringBuilder(), 0, 0, n);
            }
            
            List<String> keySet = new ArrayList<>(ordersCount.keySet());
            keySet.sort((o1, o2) -> ordersCount.get(o2).compareTo(ordersCount.get(o1)));
            
            int max = 0;
            
            if(keySet.size() != 0){
                max = ordersCount.get(keySet.get(0));
                if(max < 2){
                    break;
                }
            }
            
            for(String key : keySet) {
                if(ordersCount.get(key) != max){
                    break;
                }
                answer.add(key);
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    public static void combi(String str, StringBuilder sb, int idx, int cnt, int n){
       if(cnt == n) {
           ordersCount.put(sb.toString(),ordersCount.getOrDefault(sb.toString(),0)+1);
           return;
        }
        
        for(int i = idx ; i < str.length(); i++){
            //방문배열로 생각
            sb.append(str.charAt(i));
            combi(str,sb,i+1,cnt+1,n);
            sb.delete(cnt,cnt+1);
        }
    }
}