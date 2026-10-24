import java.util.*;
class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        boolean[][] visited = new boolean[row][col];
        int[] oilByColumn = new int[col];

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (land[x][y] == 1 && !visited[x][y]) {
                    bfs(land, visited, x, y, oilByColumn);
                }
            }
        }
        int maxSize = 0;
        for(int i=0; i<oilByColumn.length; i++){
            maxSize = Math.max(maxSize,oilByColumn[i]);
        }
        return maxSize;
    }
    public void bfs(int[][] land, boolean[][] visited, int startRow, int startCol,int[] oilByColumn){
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        Set<Integer> columns = new HashSet<>();
        int size = 0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            size++;
            columns.add(y);
            for(int i=0; i<4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                if(nx <0 || ny <0 || nx>=land.length || ny>=land[0].length)                 {
                    continue;    
                }
                if(land[nx][ny] == 1 && !visited[nx][ny]){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        for (int column : columns) {
            oilByColumn[column] += size;
        }
        
    }
}