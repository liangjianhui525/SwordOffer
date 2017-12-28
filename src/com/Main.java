package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/9/6.
 */
public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            list.removeAll(list);
            flag = false;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            String[] ss = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(ss[i]);
            }
            dfs(arr,0,k);
            if(list.size()>0){
                System.out.println("YES");
                Collections.sort(list);
                StringBuffer sb = new StringBuffer();
                for(int i : list){
                    sb.append(i+" ");
                }
                System.out.println(sb.toString().trim());
            }else {
                System.out.println("NO");
            }

        }
    }

    private static void dfs(int[] arr, int index, int k) {
        if(k < 0){
            return;
        }
        if(k == 0){
            flag = true;
            return;
        }
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            dfs(arr,index+1,k-arr[i]);
            if(flag == true){
                break;
            }
            list.remove(list.size()-1);
        }

    }
}
