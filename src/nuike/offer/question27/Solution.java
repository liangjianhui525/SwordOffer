package nuike.offer.question27;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2017/7/24.
 */


public class Solution {
    ArrayList<String> list = new ArrayList<String>();
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0){
            return list;
        }
        char[] ch = str.toCharArray();
        permutation(ch,0);

        Collections.sort(list);
        return list;
    }

    public void permutation(char[] ch, int index) {
        if(index == ch.length){
            list.add(new String(ch));
        }
            for(int i = index ; i < ch.length ;i++){
                if(i==index || ch[i]!=ch[index]){
                    swapUtil(ch,i,index);
                    permutation(ch,index+1);
                    swapUtil(ch,i,index);

                }
            }

    }
    public void swapUtil(char[] ch, int i,int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }


    public void t1(){
        String str = "abcdef";
        ArrayList<String> arrayList = Permutation(str);
        for(String s : arrayList){
            System.out.println(s);
        }
    }

}

