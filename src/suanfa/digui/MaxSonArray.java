package suanfa.digui;

/**
 * Created by Administrator on 2017/8/10.
 */
public class MaxSonArray {
    public static void main(String[] args) {
        int[] array={-1,2,3,4,-5,6};
        int maxnum = array[0];
        int minnum = array[0];
        int result = Integer.MIN_VALUE;

        int maxpre = 0 ;
        int minpre = 0 ;
        for (int i = 1; i < array.length; i++) {
            maxpre = maxnum*array[i];
            minpre = minnum*array[i];

            maxnum = Math.max(Math.max(maxpre,minpre),array[i]);
            minnum = Math.min(Math.min(maxpre,minpre),array[i]);
            result = Math.max(result,maxnum);
        }
        System.out.println(result);
    }
}
