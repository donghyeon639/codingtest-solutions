import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int value : scoville){
            pq.offer(value);
        }
        while(pq.peek() < K){
            if(pq.size() < 2){
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            int mix = first + second * 2;
            pq.offer(mix);
            answer++;
        }
        return answer;
        
    }
}