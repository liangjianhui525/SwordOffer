package nuike.haiwei;

import org.junit.Test;

/**
 * Created by Administrator on 2017/8/15.
 */
public class beibao2 {

    public int findMaxForm(String[] strs, int m, int n) {
        return find(strs,m,n,0);
    }

    public int find(String[] strs,int m, int n,int index){
        if(index >= strs.length){
            return 0;
        }
        char[] ch = strs[index].toCharArray();
        int a = 0 ;
        int b = 0 ;
        for(char c : ch){
            if(c=='0'){
                a++;
            }
            else{
                b++;
            }
        }
        if(m>=a && n>=b){
            return Math.max(find(strs,m,n,index+1),find(strs,m-a,n-b,index+1)+1);
        }else {
            return find(strs,m,n,index+1);
        }
    }

    @Test
    public void t1(){
        String[] array = {"10", "0", "1"};
        System.out.println(findMaxForm(array, 1, 1));
    }
}



//    public static int make(int[] v, int[]p , int[] q,int m , int n,int i){
//        if(i>n){
//            return 0;
//        }
//        if(q[n]==0){
//            if(m < v[i]){
//                return make(v,p,q,m,n,i+1);
//            }
//            return Math.max(make(v,p,q,m,n,i+1),make(v,p,q,m-v[i],n,i+1)+p[i]);
//        }else{
//            if(m < v[i] + v[q[i]]){
//                return make(v,p,q,m,n,i+1);
//            }
//            return Math.max(make(v,p,q,m,n,i+1),make(v,p,q,m-v[i]-v[q[i]],n,i+1)+p[i]+p[q[i]]);
//        }
//    }