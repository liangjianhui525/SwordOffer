package nuike.offer.question61;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/1.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int j = num - 1;
            int s1 = 1;
            int s2 = 1;
            int s3 = 1;
            int s4 = 1;
            for(int i = 0; i < arr.length;i++,j--){
                if(i<2){
                    if(i==0){
                        s4*=arr[i];
                        s4*=arr[j];
                    }else {
                        s4*=arr[i];
                    }

                }
                if(i <3){
                    s1*=arr[i];
                    s2*=arr[j];
                    s3*=arr[i];
                }else if(i>=3){
                    if(arr[i-3]!=0){
                        if(s3*arr[i]/arr[i-3]>s3){
                            s3=s3*arr[i]/arr[i-3];
                        }
                    }else {
                        if(s3 < 0){
                            s3=0;
                        }
                    }

                }
            }
            int max = Math.max(s1,Math.max(s2,Math.max(s3,s4)));
            System.out.println(max);
        }
    }
}
