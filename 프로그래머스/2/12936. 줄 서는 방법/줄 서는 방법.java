import java.util.Arrays;

class Solution {
    static int[] result;
    static int[] check;
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        check = new int[n+1];
        result = new int[n];
        
        // k번째 순열을 찾기 위해 반복
        for (int i = 0; i < n; i++) {
            long factorial = 1;
            for (int j = 1; j <= n - i - 1; j++) {
                factorial *= j;
            }
            
            // 해당 위치에서 가능한 숫자 찾기
            for (int j = 1; j <= n; j++) {
                if (check[j] == 0) {
                    if (k <= factorial) {
                        result[i] = j;
                        check[j] = 1;
                        break;
                    } else {
                        k -= factorial;
                    }
                }
            }
        }

        return result;
    }
}