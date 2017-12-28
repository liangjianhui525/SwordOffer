package nuike.offer.question;

import org.junit.Test;

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int left = getleft(array,k);
        int right = getright(array,k);
        return right-left+1;

    }

    public int getleft(int [] array , int k){
        int left = 0;
        int right = array.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(array[mid]>k){
                right = mid -1;
            }else if(array[mid] < k){
                left = mid +1;
            }else if(array[mid]==k && mid > left && array[mid-1]==k){
                right = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public int getright(int[] array , int k){
        int left = 0;
        int right = array.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(array[mid]>k){
                right = mid -1;
            }else if(array[mid] < k){
                left = mid +1;
            }else if(array[mid]==k && mid < right && array[mid+1]==k){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void t1(){
        int[] num = {1,2,2,2,2,3,4,5,6,7,8,9};
        System.out.println(GetNumberOfK(num,2));
    }

}