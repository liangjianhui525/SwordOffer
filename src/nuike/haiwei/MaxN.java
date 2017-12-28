package nuike.haiwei;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/14.
 */
public class MaxN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int d = sc.nextInt();
            long[][] fmax = new long[k+1][n+1];
            long[][] fmin = new long[k+1][n+1];
            long res = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                fmax[1][i] = arr[i];
                fmin[1][i] = arr[i];
                for (int j = 2; j <= k; j++) {
                    for (int l = i-1; l > 0 && i-l <= d; l--) {
                        fmax[j][i] = Math.max(fmax[j][i],Math.max(fmax[j-1][l]*arr[i],fmin[j-1][l]*arr[i]));
                        fmin[j][i] = Math.min(fmin[j][i],Math.min(fmax[j-1][l]*arr[i],fmin[j-1][l]*arr[i]));
                    }
                }
                res = Math.max(res,fmax[k][i]);
            }
            System.out.println(res);
        }
    }
}
