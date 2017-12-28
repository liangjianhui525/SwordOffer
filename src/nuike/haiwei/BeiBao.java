package nuike.haiwei;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/14.
 */
public class BeiBao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] v = new int[m+1];
            int[] p = new int[m+1];
            int[] q = new int[m+1];
            for (int i = 0; i < m; i++) {
                v[i] = sc.nextInt();
                p[i] = sc.nextInt()*v[i];
                q[i] = sc.nextInt();
            }

            int rr = make(v,p,q,m,n,1);
            System.out.println(rr);
//            int[][] dp = new int[m+1][n+1];
//
//            for (int i = 1; i <= m; i++) {
//                for (int j = 1; j <= n; j++) {
//                    if(q[i-1]==0){
//                        if(j >= v[i-1]){
//                            dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-v[i-1]]+p[i-1]);
//                        }
//
//                    }else if(q[i-1] > 0){
//                        if(j >= v[i-1]+ v[q[i-1]])
//                            dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-v[-1]-v[p[i-1]]]+p[i-1]+p[q[i-1]]);
//                    }
//                }
//            }
//            System.out.println(dp[m][n]);
        }
    }

    public static int make(int[] v, int[]p , int[] q,int m , int n,int i){
        if(i>n){
            return 0;
        }
        if(q[n]==0){
            if(m < v[i]){
                return make(v,p,q,m,n,i+1);
            }
            return Math.max(make(v,p,q,m,n,i+1),make(v,p,q,m-v[i],n,i+1)+p[i]);
        }else{
            if(m < v[i] + v[q[i]]){
                return make(v,p,q,m,n,i+1);
            }
            return Math.max(make(v,p,q,m,n,i+1),make(v,p,q,m-v[i]-v[q[i]],n,i+1)+p[i]+p[q[i]]);
        }
    }

}
