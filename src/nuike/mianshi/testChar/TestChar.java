package nuike.mianshi.testChar;



/**
 * Created by Administrator on 2017/7/15.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestChar {


    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null || pHead.next==null){
            return pHead;
        }

        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode p = first;
        ListNode last = pHead;

        while(last.next!=null){

            if(p.val==last.val){
                int temp = p.val;
                while(last!=null && last.val== temp){
                    last = last.next;
                }
                p.next = last;
            }else{
                p = last;
                last = last.next;
            }
        }
        return first.next;
    }




    public void T1(){
        
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);

        deleteDuplication(l1);

    }
}
