package nuike.mianshi.testChar;


import org.junit.Test;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Administrator on 2017/7/30.
 */
public class Solution {
    Vector<Integer> vec = new Vector<>();

    public boolean exist(char[][] board, String word) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < board.length;i++){
            for (int j = 0; j <board[0].length ; j++) {
                if(map.containsKey(board[i][j])){
                    map.put(board[i][j],map.get(board[i][j])+1);
                }else {
                    map.put(board[i][j],1);
                }
            }
        }
        char[] ch = word.toCharArray();
        int i = 0;
        for (;i<ch.length;i++){
            if(map.containsKey(ch[i])){
                map.put(ch[i],map.get(ch[i])-1);
            }else {
                return false;
            }
        }
        Set<Character> set = map.keySet();
        for(Character c : set){
            if(map.get(c)<0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void t(){
        char[][] board = {{'a','b','c','e'},{'c','a','f','s'},{'e','e','f','g'}};
        System.out.println(exist(board, "aa"));
    }
}
