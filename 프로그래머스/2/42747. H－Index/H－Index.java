import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 논문의 인용 횟수를 내림차순 정렬
        Arrays.sort(citations); 
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 남은 논문 수
            if (citations[i] >= h) {
                return h; // 조건을 만족하면 H값 반환
            }
        }
        
        return 0; // 조건을 만족하지 않는 경우
    }
}