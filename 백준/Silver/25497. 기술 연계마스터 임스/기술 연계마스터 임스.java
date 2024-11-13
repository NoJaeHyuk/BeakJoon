import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String inputs = br.readLine();

        int count = 0;
        int lCount = 0; // 'L' 기술의 개수 (사전 기술)
        int sCount = 0; // 'S' 기술의 개수 (사전 기술)

        for (char ch : inputs.toCharArray()) {
            if (ch == 'L') {
                lCount++;
            } else if (ch == 'S') {
                sCount++;
            } else if (ch == 'R') {
                // 'R' 본 기술이 등장했을 때 'L'이 없으면 종료
                if (lCount > 0) {
                    lCount--;
                    count++;
                } else {
                    break;
                }
            } else if (ch == 'K') {
                // 'K' 본 기술이 등장했을 때 'S'가 없으면 종료
                if (sCount > 0) {
                    sCount--;
                    count++;
                } else {
                    break;
                }
            } else {
                // 숫자 기술은 단독으로 사용 가능
                count++;
            }
        }

        System.out.println(count);
    }
}