package nuike.offer.question15;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        Queue<Integer> queue = new LinkedList();
        int num = 0;
        int count = 0;
        if(n < 0 || m <=0){
            return -1;
        }
        for(int i = 0 ; i < n ; i++){
            queue.add(i);
        }
        while (!queue.isEmpty()){
            count++;
            if(count == m){
                num = queue.peek();
                count = 0;
                num = queue.poll();
            } else {
                queue.offer(queue.poll());
            }

        }
        return num;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.LastRemaining_Solution(5,2));
    }
}
