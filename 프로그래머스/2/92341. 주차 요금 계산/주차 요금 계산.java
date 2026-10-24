import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicfee = fees[1];
        int unitTime = fees[2];
        int unitfee = fees[3];
        Map<String, Integer> inTimes = new HashMap<>();
        Map<String, Integer> totalTimes = new HashMap<>();
        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            String[] hm = record[0].split(":");
            int minute = Integer.parseInt(hm[0]) * 60 
                + Integer.parseInt(hm[1]);
            String carno = record[1];
            String entry = record[2];
            
            if(entry.equals("IN")){
                inTimes.put(carno, minute);
            }
            if(entry.equals("OUT")){
                int intime = inTimes.get(carno);
                int duration = minute - intime;
                inTimes.remove(carno);
                if(totalTimes.containsKey(carno)){
                    int total = totalTimes.get(carno);
                    totalTimes.put(carno, total+duration);
                }
                else{
                    totalTimes.put(carno, duration);
                }
            }
        }
        int endTime = 23 * 60 + 59;
        for(String carno : inTimes.keySet()){
            int intime = endTime - inTimes.get(carno);
            if(totalTimes.containsKey(carno)){
                int total = totalTimes.get(carno);
                totalTimes.put(carno, total + intime);
            }
            else{
                totalTimes.put(carno, intime);
            }
        }
        List<String> carNumbers = new ArrayList<>(totalTimes.keySet());
        Collections.sort(carNumbers);
        
        
        int[] answer = new int[carNumbers.size()];
        
        int index = 0;
        for(int i=0; i<carNumbers.size(); i++){
            String carno = carNumbers.get(i);
            int total = totalTimes.get(carno);
            
            if(total>basicTime){
                int totalfee = basicfee
                + (int) Math.ceil(
                    (double) (total - basicTime) / unitTime
                ) * unitfee;
                answer[i] = totalfee;
            }
            else{
                answer[i] = basicfee;
            }
        }
        return answer;
    }
}