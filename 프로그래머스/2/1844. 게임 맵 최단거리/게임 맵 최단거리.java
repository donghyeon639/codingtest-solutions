import java.util.*;
class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    public int solution(int[][] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        int answer = dfs(maps, visited,0,0);
        return answer;
    }
    public int dfs(int[][] maps, boolean[][] visited,int startRow, int startCol){
        Queue<int[]> q = new LinkedList<>();
        visited[startRow][startCol] = true;
        q.offer(new int[]{startRow,startCol,1});
        while(!q.isEmpty()){
            int[] current = q.poll();
            int curRow = current[0];
            int curCol = current[1];
            int distance = current[2];
            if(curRow == maps.length-1 && curCol == maps[0].length-1){
                return distance;
            }
            for(int i=0; i<4; i++){
                int nx = dx[i] + curRow;
                int ny = dy[i] + curCol;
                
                if(nx <0 || nx>maps.length-1 || ny <0 
                   || ny > maps[0].length-1){
                    continue;    
                }
                if(maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,distance +1});
                }                
            }
        }
        return -1;
    }
}