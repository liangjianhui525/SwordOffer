package nuike.mianshi.testChar;

import org.junit.Test;

import java.util.*;
public class Solution2 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length <1){
            return false;
        }
        return isBST(sequence);
    }

    public boolean isBST(int [] sequence){
        if(sequence.length <= 1){
            return true;
        }
        int i = 0 ;
        for(;i < sequence.length-1;i++){
            if(sequence[i] > sequence[sequence.length-1]){
                break;
            }
        }
        for(int j = i ; j < sequence.length-1;j++){
            if(sequence[j] < sequence[sequence.length-1]){
                return false;
            }
        }
        return isBST(Arrays.copyOfRange(sequence,0,i)) &&
                isBST(Arrays.copyOfRange(sequence,i,sequence.length));
    }

    @Test
    public void t1(){
        int [] sequence = {4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(sequence));
    }
}