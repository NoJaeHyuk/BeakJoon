class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String result = "";
        int num = 0;

        while(result.length() < t * m){
            //toString(int n, int radix)
            result += Integer.toString(num++, n);
        }

        // 튜브가 말해야 하는 숫자
        for(int i = p-1; i < m*(t-1)+p; i += m){
            answer += result.charAt(i);
        }

        return answer.toUpperCase();
    }
}