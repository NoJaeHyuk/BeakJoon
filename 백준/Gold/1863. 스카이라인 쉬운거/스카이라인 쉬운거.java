import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 지점의 수

        Stack<Integer> stack = new Stack<>();
        int buildingCount = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x 좌표 (사용하지 않음)
            int y = Integer.parseInt(st.nextToken()); // y 좌표 (높이)

            // 스택이 비어있지 않고, 현재 높이가 스택의 최상단 높이보다 낮을 때
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop(); // 스택에서 제거
                buildingCount++; // 건물 개수 증가
            }

            // 스택이 비어있거나, 현재 높이가 스택의 최상단 높이와 다를 때
            if (stack.isEmpty() || stack.peek() != y) {
                stack.push(y); // 현재 높이를 스택에 추가
            }
        }

        // 스택에 남아있는 높이 처리
        while (!stack.isEmpty()) {
            if (stack.pop() > 0) {
                buildingCount++;
            }
        }

        System.out.println(buildingCount); // 결과 출력
    }
}