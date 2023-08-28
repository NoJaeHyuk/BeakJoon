import java.util.*;

class Solution {
    

    public String solution(int n) {
        String answer = "";
        
        String[] array = {"4","1","2"};
        
        List<String> a = new ArrayList<>();
        
        while(n != 0){
            a.add(array[n%3]);
            
            if(n%3 == 0){
                 n = (n/3) - 1;
            }else{
                 n = n/3; 
            }
        }
        
        for(int i = a.size()-1; i >= 0; i-- ){
            //System.out.println(a.get(i));
            answer += a.get(i);
        }
        
        return answer;
    }
}