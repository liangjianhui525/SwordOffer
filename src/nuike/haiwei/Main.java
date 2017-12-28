package nuike.haiwei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.next();
            String s2 = sc.next();
            String res = mul(s1,s2);
            System.out.println(res);
        }

    }
    public static String mul(String s1,String s2){
        String sin1 = s1.substring(0,1);
        String sin2 = s2.substring(0,1);
        String sin = "+";
        if((sin1.equals("-")&&(!sin2.equals("-")))||(sin2.equals("-")&&(!sin1.equals("-")))){
            sin = "-";
        }
        if(sin1.equals("-")||sin1.equals("+")){
            s1=s1.substring(1);
        }
        if(sin2.equals("-")||sin2.equals("+")){
            s2=s2.substring(1);
        }
        char[] ch1 = new StringBuffer(s1).reverse().toString().toCharArray();
        char[] ch2 = new StringBuffer(s2).reverse().toString().toCharArray();
        int len = ch1.length+ch2.length;
        int[] ch = new int[len];
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                ch[i+j] = (int) ((ch1[i]-'0')*(ch2[j]-'0'));
            }
        }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] > 10) {
                ch[i + 1] += ch[i] / 10;
                ch[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        if(sin.equals("-")) sb.append("-");
        int index = ch.length-1;
        for (; index >=0 ; index--) {
            if(ch[index]!=0) {
                break;
            }
        }
        for (int i = index; i >=0 ; i--) {
            sb.append(String.valueOf(ch[i]));
        }
        if(sb.equals("")){
            sb.append("0");
        }
        return sb.toString();
    }
}




