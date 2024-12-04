import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 지원자 수
            TreeSet<int[]> applicants = new TreeSet<>((a, b) -> a[0] - b[0]); // 서류 성적 기준 정렬
            
            // 지원자 정보 입력
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int docScore = Integer.parseInt(st.nextToken());
                int interviewScore = Integer.parseInt(st.nextToken());
                applicants.add(new int[]{docScore, interviewScore});
            }
            
            int count = 0;
            int minInterviewScore = Integer.MAX_VALUE; // 현재까지의 최소 면접 성적
            
            // TreeSet을 순회하며 선발
            for (int[] applicant : applicants) {
                if (applicant[1] < minInterviewScore) { // 면접 성적이 더 좋을 경우 선발
                    count++;
                    minInterviewScore = applicant[1]; // 최소 면접 성적 갱신
                }
            }
            
            sb.append(count).append("\n");
        }
        
        System.out.print(sb);
    }
}
