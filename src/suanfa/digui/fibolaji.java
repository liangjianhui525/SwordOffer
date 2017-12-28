package suanfa.digui;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/13.
 */
public class fibolaji {
    List<Integer> list = new ArrayList<>();
    public int fiBo(int n){
        if(n==1 || n==2){

            return 1;
        }
        int num = fiBo(n-1)+fiBo(n-2);
        list.add(num);
        return num;
    }

    @Test
    public void t1(){
        fiBo(4);
        for(Integer i : list){
            System.out.print(i + " ");
        }
    }

}
