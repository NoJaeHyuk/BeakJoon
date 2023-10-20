import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> mList = new ArrayList();
        
        
        for(String str : strArr){
            if(!str.contains("ad")){
                mList.add(str);
            }
        }
        
        String[] answer = mList.toArray(new String[mList.size()]);
    
        return answer;
    }
}