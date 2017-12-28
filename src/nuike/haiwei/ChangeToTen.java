package nuike.haiwei;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/15.
 */
public class ChangeToTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while (sc.hasNext()){
            String s = sc.next();
            char[] ch = s.toUpperCase().substring(2).toCharArray();
            int res = 0;
            for (int i = ch.length-1; i >=0 ; i--) {
                int ii = 0;
                if(ch[i]>-'0'&&ch[i]<='9'){
                    ii = ch[i]-'0';
                }else {
                    ii = ch[i]-'A'+10;
                }
                res += ii*Math.pow(16,ch.length-i-1);
            }
            System.out.println(String.valueOf(res));
        }
    }
}
