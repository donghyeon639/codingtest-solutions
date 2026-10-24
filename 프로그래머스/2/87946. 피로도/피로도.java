class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int[] count = new int[dungeons.length];
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0, visited);
        return answer;
    }
    
    public void dfs(int[][] dungeons,int curhp, int count, boolean[] visited  ){    
        answer = Math.max(answer, count);
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && curhp>=dungeons[i][0]){
                visited[i] = true;
                dfs(dungeons, curhp-dungeons[i][1], count+1, visited);
                
                visited[i] = false;
            }
        }    
        
    }
}
// 던전1 > 던전2> 던전3
// 던전 1 > 던전3 > 던전 2