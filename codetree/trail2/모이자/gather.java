import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] total = new int[n];
        int minTotal = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                total[i] += a[j] * Math.abs(j-i);
            }
        }

        for(int i=0; i<n; i++){
            if(total[i] < minTotal){
                minTotal = total[i];
            }
        }
        System.out.println(minTotal);

    }
}