import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> st = new Stack<>();
        int index = 0;
        int box = 1;

        while (index < order.length) {
            int target = order[index];

            // 아직 넣지 않은 상자부터 필요한 번호까지 넣기
            for (; box <= target; box++) {
                st.push(box);
            }

            if (!st.isEmpty() && st.peek() == target) {
                st.pop();
                index++;
            } else {
                break;
            }
        }

        return index;
    }
}