import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean visited[] = new boolean[computers.length];
        for(int i=0; i<computers.length; i++){
            if(!visited[i]){
                bfs(n, computers, visited, i);
                count++;
            }
        }
        return count;
    }
    public void bfs(int n, int[][] computers, boolean visited[], int index){
        Queue<Integer> q = new LinkedList<>();
        visited[index] = true;
        q.offer(index);
        
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i=0; i<n; i++){
                if(computers[current][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        
    }
}

