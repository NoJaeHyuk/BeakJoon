import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();
        //뒤로 가서 체크
        for(int i = numbers.length-1; i >= 0; i--){
            int cur = numbers[i];
            
            while (!stack.isEmpty()){
                if(cur < stack.peek()){
                    answer[i] = stack.peek();
                    break;
                }else{
                    stack.pop();        
                }
            }
            
            if(stack.isEmpty()){
                answer[i] = -1;
            }
            stack.push(cur);
        }

        return answer;
    }
}