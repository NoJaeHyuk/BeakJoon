import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        List<Integer> arrNum = new ArrayList<>();
        while(storey > 0) {
            arrNum.add(storey % 10);
            storey /= 10;
        }
        
        for(int i = 0; i < arrNum.size(); i++){ 
            System.out.println(arrNum.get(i));
            if(arrNum.get(i) > 5){
                int ten = 10 - arrNum.get(i);
                
                if(i == arrNum.size()-1){
                    arrNum.add(i+1, 1);  
                }else{
                    arrNum.set(i+1, arrNum.get(i+1)+1);        
                }
                
                answer += ten;
            }else if(arrNum.get(i) == 5 && i < arrNum.size()-1 && arrNum.get(i+1) >= 5) {
               
                if(i == arrNum.size()-1){
                    arrNum.add(i+1, 1);  
                }else{
                    arrNum.set(i+1, arrNum.get(i+1)+1);        
                }        
                         
    			answer += 5;
    		}else{     
                answer += arrNum.get(i);   
            }
        }
        
        return answer;
    }
}