class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int xCount = 1;
        int xNotCount = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (xCount == 0 && xNotCount == 0) {
                x = s.charAt(i);
                xCount = 1;
                continue;
            }
            
            if (x == s.charAt(i)) {
                xCount++;
            } else {
                xNotCount++;
            }
            
            if (xCount == xNotCount) {
                answer++;
                xCount = 0;
                xNotCount = 0;
            }
        }
        
        if (xCount != 0 || xNotCount != 0) { // 남은 문자열이 있다면 answer 추가
            answer++;
        }
        
        return answer;
    }
}