package nuike.offer.question1;

/**
 * Created by Administrator on 2017/7/21.
 */
public class Solution {

    public boolean Find(int [][] array,int target) {
        int length = array.length-1;
        int i = 0;
        while(length>=0 && i < array[0].length){
            if(array[i][length]== target){
                return true;
            }else if(array[i][length] > target){
                i++;
            }else {
                length--;
            }

        }
        return false;
    }
}
