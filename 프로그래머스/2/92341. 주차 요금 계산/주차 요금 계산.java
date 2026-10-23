import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicfee = fees[1];
        int feetime = fees[2];
        int fee = fees[3];

        Map<String, Integer> inTimes = new HashMap<>();
        Map<String, Integer> totalTimes = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] words = records[i].split(" ");
            String[] hm = words[0].split(":");
            String carno = words[1];
            String entry = words[2];

            int min = Integer.parseInt(hm[0]) * 60
                    + Integer.parseInt(hm[1]);

            if (entry.equals("IN")) {
                inTimes.put(carno, min);
            } else {
                int intime = inTimes.get(carno);
                int duration = min - intime;

                inTimes.remove(carno);

                if (totalTimes.containsKey(carno)) {
                    int total = totalTimes.get(carno);
                    totalTimes.put(carno, total + duration);
                } else {
                    totalTimes.put(carno, duration);
                }
            }
        }

        // 출차 기록이 없는 차량 처리
        int endTime = 23 * 60 + 59;

        for (String carno : inTimes.keySet()) {
            int intime = inTimes.get(carno);
            int duration = endTime - intime;

            if (totalTimes.containsKey(carno)) {
                int total = totalTimes.get(carno);
                totalTimes.put(carno, total + duration);
            } else {
                totalTimes.put(carno, duration);
            }
        }

        // 차량 번호 오름차순 정렬
        List<String> carNumbers = new ArrayList<>(totalTimes.keySet());
        Collections.sort(carNumbers);

        // 차량 수만큼 결과 배열 생성
        int[] answer = new int[carNumbers.size()];

        for (int i = 0; i < carNumbers.size(); i++) {
            String carno = carNumbers.get(i);
            int totaltime = totalTimes.get(carno);

            if (totaltime <= basicTime) {
                answer[i] = basicfee;
            } else {
                int extraTime = totaltime - basicTime;
                int count = (int) Math.ceil((double) extraTime / feetime);

                answer[i] = basicfee + count * fee;
            }
        }

        return answer;
    }
}