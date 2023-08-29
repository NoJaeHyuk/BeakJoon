import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        // order 배열의 포인터
        int op = 0;
        // 컨테이너 벨트에서 현재 확인중인 박스 번호
        int currentBox = 1;
        // 보조 컨테이너 벨트
        Stack<Integer> assistanceBelt = new Stack<>();
        while (op < order.length) {
            // 트럭에 실릴 박스의 번호가 현재 컨테이너 벨트의 박스 번호보다 크면
            if (order[op] > currentBox) {
                // 보조 벨트에 현재 박스를 보관한다.
                assistanceBelt.push(currentBox);
                currentBox++;
            }
            // 트럭에 실릴 박스의 번호가 현재 컨테이너 벨트의 박스 번호와 같으면
            else if (order[op] == currentBox) {
                // 트럭에 싣는다.
                answer++;
                op++;
                currentBox++;
            }
            // 트럭에 실릴 박스의 번호가 현재 컨테이너 벨트의 박스 번호보다 작으면
            else {
                // 보조 벨트를 확인한다.
                while (!assistanceBelt.isEmpty() && order[op] == assistanceBelt.peek()) {
                    assistanceBelt.pop();
                    answer++;
                    op++;
                }
                // 트럭에 모두 실었으면 종료.
                // 또는 여전히 트럭에 실을 박스 번호가 현재 컨테이너 벨트의 박스 번호보다 작으면 종료.
                // 보조 벨트에도 원하는 박스가 없고, 컨테이너 벨트는 계속해서 더 큰 번호의 박스가 등장함.
                // 따라서 더 이상 박스를 싣지 못함.
                if (op >= order.length || order[op] < currentBox) break;
            }
        }

        return answer;
    }
}