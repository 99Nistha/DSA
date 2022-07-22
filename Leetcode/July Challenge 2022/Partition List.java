class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode temp= head;
        ListNode s= new ListNode(0);
        ListNode small= s;
        ListNode l= new ListNode(0);
        ListNode large= l;
        while(temp!=null){
            if(temp.val<x){
                small.next= temp;
                small= temp;
                temp= temp.next;
                small.next= null;
            }else{
                large.next= temp;
                large= temp;
                temp= temp.next;
                large.next= null;
            }
        }
        small.next= l.next;
        return s.next;
    }
}
