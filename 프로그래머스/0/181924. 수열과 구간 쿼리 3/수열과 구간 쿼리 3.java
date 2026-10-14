class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i=0; i<queries.length; i++){
            int index1 = queries[i][0];
            int index2 = queries[i][1];
            
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
        return arr;
    }
}