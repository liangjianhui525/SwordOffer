package suanfa.digui;

import org.junit.Test;

/**
 * Created by Administrator on 2017/8/10.
 */
public class DiguiDemo1 {
    int Factorial(int n){
        if(n == 0){
            return 1;
        }

        return n*Factorial(n-1);
    }

    @Test
    public void testDigui(){
        long n = Factorial(3);
        System.out.println(n);
    }
}
