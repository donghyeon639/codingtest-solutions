import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();

        // 각 문자가 스포 방지 구간에 포함되는지 표시
        boolean[] isSpoilerIndex = new boolean[n];

        for (int[] range : spoiler_ranges) {
            int start = range[0];
            int end = range[1];

            // start와 end 모두 포함
            for (int i = start; i <= end; i++) {
                isSpoilerIndex[i] = true;
            }
        }

        Set<String> spoilerWords = new HashSet<>();
        Set<String> normalWords = new HashSet<>();

        int index = 0;

        while (index < n) {
            // 앞쪽 공백 건너뛰기
            while (index < n && message.charAt(index) == ' ') {
                index++;
            }

            if (index >= n) {
                break;
            }

            int wordStart = index;

            while (index < n && message.charAt(index) != ' ') {
                index++;
            }

            int wordEnd = index; // 실제 마지막 인덱스 + 1
            boolean isSpoilerWord = false;

            // 단어 문자 중 하나라도 스포 구간에 포함되는지 확인
            for (int i = wordStart; i < wordEnd; i++) {
                if (isSpoilerIndex[i]) {
                    isSpoilerWord = true;
                    break;
                }
            }

            String word = message.substring(wordStart, wordEnd);

            if (isSpoilerWord) {
                spoilerWords.add(word);
            } else {
                normalWords.add(word);
            }
        }

        // 비스포 구간에도 등장한 단어는 중요하지 않음
        spoilerWords.removeAll(normalWords);

        return spoilerWords.size();
    }
}