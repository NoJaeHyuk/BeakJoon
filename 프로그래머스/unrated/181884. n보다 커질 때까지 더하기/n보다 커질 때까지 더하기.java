class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        
        for(int ix : numbers){
            answer += ix;
            if(answer > n){
                break;
            }
        }
        return answer;
    }
}