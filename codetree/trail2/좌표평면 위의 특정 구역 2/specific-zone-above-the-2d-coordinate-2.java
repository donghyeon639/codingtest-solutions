import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            points[i][0] = x;
            points[i][1] = y;
        }
        long resultSize = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            int maxX = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;
            for(int j=0; j<N; j++){
                if(i==j) continue;
                if (points[j][0] > maxX) {
                    maxX = points[j][0];
                }
                if (points[j][0] < minX) {
                    minX = points[j][0];
                }

                if (points[j][1] > maxY) {
                    maxY = points[j][1];
                }
                if (points[j][1] < minY) {
                    minY = points[j][1];
                }
            }
            long size = ((long) maxX - minX) * ((long) maxY - minY);
            if (size < resultSize) {
            resultSize = size;
            }
        }

        System.out.println(resultSize);
    }
}