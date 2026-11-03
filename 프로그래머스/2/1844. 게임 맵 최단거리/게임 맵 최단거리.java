import java.util.*;
class Solution {
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        int answer = bfs(maps, visited, 0, 0);
        return answer;
    }
    private int bfs(int[][] maps, boolean[][] visited, int startRow, int startCol ){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startRow, startCol,1});
        visited[startRow][startCol] = true;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            if(x == maps.length-1 && y == maps[0].length-1){
                return distance;
            }
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx <0 || ny <0 || nx>=maps.length || ny >= maps[0].length){
                    continue;
                }
                if(!visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }
}