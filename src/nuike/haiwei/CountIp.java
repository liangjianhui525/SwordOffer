package nuike.haiwei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/14.
 */
public class CountIp {
    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    static int e = 0;
    static int pr = 0;
    static int err = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            List<String> list = new ArrayList<>();
            list.add(sc.next());
            for(String s : list){
                String[] ss = s.split("~");
                String ip = ss[0];
                String mark = ss[1];
                String[] ips = ip.split("\\.");
                String[] marks = mark.split("\\.");
                cout(ips,marks);
            }
        }
        System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+err+" "+pr);
    }

    private static void cout(String[] ips, String[] marks) {
        if(ips.length!=4 || marks.length!=4){
            err++;
            return;
        }
        int i1=Integer.parseInt(ips[0]);
        int i2=Integer.parseInt(ips[1]);
        int i3=Integer.parseInt(ips[2]);
        int i4=Integer.parseInt(ips[3]);
        int m1=Integer.parseInt(marks[0]);
        int m2=Integer.parseInt(marks[1]);
        int m3=Integer.parseInt(marks[2]);
        int m4=Integer.parseInt(marks[3]);

        if(i1>255 || i1<0 ||i2>255 || i2<0 ||i3>255 || i3<0 ||i4>255 || i4<0 ){
            err++;
            return;
        }
        if(m1>255 || m1<0 ||m2>255 || m2<0 ||m3>255 || m3<0 ||m4>255 || m4<0 ){
            err++;
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(Integer.toBinaryString(m1)).append(Integer.toBinaryString(m2)).append(Integer.toBinaryString(m3)).append(Integer.toBinaryString(m4));
        if(sb.charAt(0)=='0'){
            err++;
            return;
        }
        int index = sb.length()-1;
        for (; index>=0; index--){
            if(sb.charAt(index)=='1') {
                break;
            }
        }
        for(int i = index ; i >=0 ; i--){
            if(sb.charAt(i)=='0'){
                err++;
                return;
            }
        }

        if(Integer.parseInt(ips[0])>=1 && Integer.parseInt(ips[0])<=126){
            if(i1==10){
                pr++;
            }
                a++;

        }else if(Integer.parseInt(ips[0])>=128 && Integer.parseInt(ips[0])<=191){
            if(i1==172 && i2 >= 16 && i2 <=31){
                pr++;
            }
                b++;

        }else if(Integer.parseInt(ips[0])>=192 && Integer.parseInt(ips[0])<=223){
            if(i1==192 && i2==168 ){
                pr++;
            }
                c++;

        }else if(Integer.parseInt(ips[0])>=224 && Integer.parseInt(ips[0])<=239){
            d++;
        }else if(Integer.parseInt(ips[0])>=240 && Integer.parseInt(ips[0])<=255){
            e++;
        }else {
            err++;
        }
    }
}





