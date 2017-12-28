package bishi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/12.
 */
public class LCSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            int result = find2(s1, s2);
            System.out.println(result);
        }
    }

    public static int find2(String s1,String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int x = 0;
        int y = 0;
        int result = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = 0;
                }
                if(dp[i][j] > result){
                    result = dp[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(x>=0 && y >=0){
            if(dp[x][y]>=1){
                sb.append(s1.charAt(x-1));
                x--;
                y--;
            }else {
                break;
            }
        }
        System.out.println(sb.reverse().toString());
        return result;
    }
}
