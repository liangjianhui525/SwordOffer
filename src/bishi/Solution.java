package bishi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String sx = sc.next();
            String[] number = sc.next().split(",");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < number.length; i++) {
                list.add(change(number[i]));
            }
            Collections.sort(list);
            StringBuffer sb = new StringBuffer();
            if(sx.toUpperCase().equals("ASCE")){
                for (int i = 0; i < list.size()-1; i++) {
                    sb.append(list.get(i)).append(",");
                }
                sb.append(list.get(list.size()-1));
            }else {
                for (int i = list.size()-1; i >0 ; i--) {
                    sb.append(list.get(i)).append(",");
                }
                sb.append(list.get(0));
            }
            System.out.println(sb.toString());
        }
    }


    public static int change(String s){
        int flag = 0;
        if(s.substring(0,1).equals("-")){
            s = s.substring(1);
            flag = 1;
        }else if(s.substring(0,1).equals("+")){
            s = s.substring(1);
            flag = 0;
        }
        char[] ch = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            list.add(ch[i]);
        }
        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        if(flag==0) {
            if (list.contains('0') && ch.length >= 2) {
                sb.append(list.get(0)).append('0');
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != '0') {
                        sb.append(list.get(i));
                        list.remove(i);
                        break;
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                }
            }
        }else {
            if(list.contains('0')&&ch.length>=2){
                sb.append(list.get(0)).append('0');
                for (int i = list.size()-1; i >=0 ; i--) {
                    if(list.get(i)!='0'){
                        sb.append(list.get(i));
                        list.remove(i);
                        break;
                    }
                }
                for (int i = list.size()-1; i >=0 ; i--) {
                    sb.append(list.get(i));
                }
            }else {
                for (int i = list.size()-1; i >= 0 ; i--) {
                    sb.append(list.get(i));
                }
            }
        }




        if (flag == 0) {
            return Integer.parseInt(sb.toString());
        }else {
            return 0-Integer.parseInt(sb.toString());
        }

    }

}