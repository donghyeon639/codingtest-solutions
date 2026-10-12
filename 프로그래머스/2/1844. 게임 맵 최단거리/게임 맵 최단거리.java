import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        return bfs(maps, 0, 0);
    }
    public int bfs(int[][] maps, int startRow, int startCol){
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        visited[startRow][startCol] = true;
        q.offer(new int[]{startRow, startCol,1});
        
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

                if(nx <0 || nx>=maps.length || ny < 0 || ny >= maps[0].length ){
                    continue;
                }

                if(maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,distance+1});
                }
            }
        }
        return -1;
        
        
    }
}