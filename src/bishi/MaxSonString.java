package bishi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/12.
 */
public class MaxSonString {
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
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i = s1.length();
        int j = s2.length();
        StringBuffer sb = new StringBuffer();
        while(i>0 || j >0){
            if(dp[i][j] != dp[i][j-1] && dp[i][j]!=dp[i-1][j] ){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i][j] == dp[i-1][j]){
                i--;
            }else {
                j--;
            }
        }
        System.out.println(sb.reverse().toString());

        return dp[s1.length()][s2.length()];
    }


    public static int find(String s1,String s2,int i, int j){
        if(i>=s1.length()||j>=s2.length()){
            return 0;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+find(s1,s2,i+1,j+1);
        }else {
            return Math.max(find(s1,s2,i+1,j),find(s1,s2,i,j+1));
        }
    }
}
