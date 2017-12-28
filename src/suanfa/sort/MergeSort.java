package suanfa.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/26.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {4,6,8,9,7,3,1,2,5};
        int len = array.length;
        mergeSort(array,0,len-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int left, int right) {
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left +1;
        int n2 = right - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];
        int k = 0;
        int i = 0;
        int j = 0;
        for (i = 0,k=left; i < n1; i++,k++) {
            l[i] = array[k];
        }
        for (j = 0,k=mid+1; j < n2; j++,k++) {
            r[j] = array[k];
        }
        for (i = 0,j=0,k=left; i <n1 && j < n2 ; ) {
            if(l[i] > r[j]){
                array[k++] = l[i++];
            }else {
                array[k++] = r[j++];
            }
        }
        while(i < n1){
            array[k++] = l[i++];
        }
        while(j < n2){
            array[k++] = r[j++];
        }

    }
}
