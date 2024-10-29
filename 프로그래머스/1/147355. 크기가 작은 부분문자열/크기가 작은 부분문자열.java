class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int plength = p.length();
        long pLong = Long.parseLong(p);
            
        for(int i = 0; i < t.length(); i++) {
            if(i + plength > t.length()) {
                break;
            }
            long chkLong = Long.parseLong(t.substring(i, i + plength));
            if(chkLong <= pLong) {
                answer++;
            }
        }
        return answer;
    }
}