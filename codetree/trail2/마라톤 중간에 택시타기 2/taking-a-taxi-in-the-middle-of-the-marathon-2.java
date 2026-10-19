import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] grid = new int[n][2];
        for(int i=0; i<n; i++){
            grid[i][0] = x[i];
            grid[i][1] = y[i];
        }
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 1; i < n - 1; i++) {
            int totalDist = 0;
            int prev = 0; // 직전에 방문한 지점

            for (int j = 1; j < n; j++) {
                if (j == i) continue;

                totalDist += Math.abs(grid[j][0] - grid[prev][0]);
                totalDist += Math.abs(grid[j][1] - grid[prev][1]);

                prev = j;
            }

            if (minDist > totalDist) {
                minDist = totalDist;
            }
        }
        System.out.println(minDist);
    }
}