package suanfa.digui;

import org.junit.Test;

/**
 * Created by Administrator on 2017/8/10.
 */
public class Triangle {
    int[][] arr = {
                    {5},
                    {3,8},
                    {8,1,0},
                    {2,7,4,4},
                    {4,5,2,6,5}
                  };
    public int MaxSum(int i,int j){
        if(i==arr.length-1){
            return arr[i][j];
        }
        return Math.max(MaxSum(i+1,j),MaxSum(i+1,j+1))+arr[i][j];
    }

    @Test
    public void testT(){
        System.out.println(MaxSum(0,0));
    }

    @Test
    public void dp(){
        int[][] max =new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            max[arr.length-1][i] = arr[arr.length-1][i];
        }

        for (int i = arr.length-2;i>=0;i--){
            for (int j = 0; j <=i ; j++) {
                max[i][j] = Math.max(max[i+1][j],max[i+1][j+1])+arr[i][j];
            }
        }
        System.out.println(max[0][0]);
    }

}
