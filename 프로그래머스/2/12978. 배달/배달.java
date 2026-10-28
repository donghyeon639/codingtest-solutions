import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] roads : road){
            int start = roads[0];
            int end = roads[1];
            int time = roads[2];
            
            graph.get(end).add(new int[]{start,time});
            graph.get(start).add(new int[]{end,time}); 
        }
        
        int[] minTime = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );
        Arrays.fill(minTime, Integer.MAX_VALUE);
        pq.offer(new int[]{1,0});
        minTime[1] = 0;
        
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int village = current[0];
            int time = current[1];
            
            if(time > minTime[village]){
                continue;
            }
            for(int[] nextroad : graph.get(village)){
                int nextvill = nextroad[0];
                int moveTime = nextroad[1];
                int nextTime = time + moveTime;
                if(nextTime > K){
                    continue;
                }
                if(nextTime < minTime[nextvill]){
                    minTime[nextvill] = nextTime;
                    pq.offer(new int[]{nextvill, nextTime});
                }
            }
        }
        for(int i=0; i<=N; i++){
            if(minTime[i] <=K){
                answer++;
            }
        }


        return answer;
    }
}