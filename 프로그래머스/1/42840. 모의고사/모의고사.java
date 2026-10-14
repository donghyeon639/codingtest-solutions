class Solution {
    public int[] solution(int[] answers) {
        int[] counter = new int[3];
        
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3 , 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) {
                counter[0]++;
            }
            if(answers[i] == person2[i % person2.length]){
                counter[1]++;
            }
            if(answers[i] == person3[i % person3.length]){
                counter[2]++;
            }
        }
        // 가장 높은 점수
        int maxScore = Math.max(
            counter[0],
            Math.max(counter[1], counter[2])
        );
        int winnerCount = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == maxScore) {
                winnerCount++;
            }
        }
        int[] winner = new int[winnerCount];
        int index = 0;
        for(int i=0; i<counter.length; i++){
            if(maxScore == counter[i]){
                winner[index] = i+1;
                index++;
            }
        }
        
        return winner;
    }
}
//1번 수포자 1,2,3,4,5 순차적임
//2번 수포자 (2,1) (2,3) (2,4) (2,5) 반복
//3번 수포자 3,3  1,1  2,2  4,4  5,5 반복