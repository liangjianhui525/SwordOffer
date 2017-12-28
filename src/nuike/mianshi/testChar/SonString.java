package nuike.mianshi.testChar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/31.
 */
public class SonString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap<>();
        while(sc.hasNext()) {
            int num = sc.nextInt();
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int sum = 0 ;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for(Map.Entry<Integer, Integer> each : set){
            sum+=each.getValue();
        }
        for(Map.Entry<Integer, Integer> each : set){
            if(each.getValue()>=sum/2){
                System.out.println(each.getKey());
                break;
            }
        }
    }
}
