import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<int[]>> graph = new ArrayList<>();

        // 마을 번호가 1~N이므로 N+1개 생성
        // 0번 위치는 사용하지 않음
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] roads : road) {
            int start = roads[0];
            int end = roads[1];
            int time = roads[2];

            // {이웃 마을, 이동 시간}
            // 양방향이므로 양쪽에 저장
            graph.get(start).add(new int[]{end, time});
            graph.get(end).add(new int[]{start, time});
        }

        int[] mintime = new int[N + 1];
        Arrays.fill(mintime, Integer.MAX_VALUE);

        // {마을 번호, 누적 이동 시간}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
        );

        // 1번 마을에서 시작
        mintime[1] = 0;
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int village = current[0];
            int time = current[1];

            if (time != mintime[village]) {
                continue;
            }

            for (int[] nextRoad : graph.get(village)) {
                int next = nextRoad[0];
                int moveTime = nextRoad[1];

                int nextTime = time + moveTime;

                // K를 초과하는 경로는 탐색하지 않음
                if (nextTime > K) {
                    continue;
                }

                if (nextTime < mintime[next]) {
                    mintime[next] = nextTime;
                    pq.offer(new int[]{next, nextTime});
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (mintime[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}