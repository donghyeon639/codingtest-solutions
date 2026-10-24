import java.util.*;
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1}; 

    public int solution(String[] board) {
        int distance = 0;

        int startRow = 0;
        int startCol = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        boolean[][] visited = new boolean[board.length][board[0].length()];
        int answer = bfs(board,startRow,startCol, visited);
       
        return answer;
    }
    public int bfs(String[] board, int startRow, int startCol, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        visited[startRow][startCol] = true;
        q.offer(new int[]{startRow, startCol,0});
        int row = board.length;
        int col = board[0].length();
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y= current[1];
            int count = current[2];
            if (board[x].charAt(y) == 'G') {
                return count;
            }
            for(int i=0; i<4; i++){
                int nx = x;
                int ny = y;
                
                while(true){
                    int nextx = dx[i] + nx;
                    int nexty = dy[i] + ny;
                    if(nextx <0 || nexty < 0 || nexty>=board[0].length() || nextx >= board.length)
                    {
                        break;    
                    }
                    
                    if(board[nextx].charAt(nexty) == 'D'){
                        break;
                    }
                    nx = nextx;
                    ny = nexty;
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, count + 1});
                }
            }
        }
        return -1;
    }
}
//이동의 정의 상하좌우 중 한방향으로 장애물이나 게임판 가장자리에 도달했을때
/* 왼쪽: y == 0
오른쪽: y == board[0].length() - 1
위쪽: x == 0
아래쪽: x == board.length - 1 */