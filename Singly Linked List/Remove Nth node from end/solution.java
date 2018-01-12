class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
                  
        ListNode prevToTarget = null;
        ListNode current = head;
        
        while(n-- != 0){                 // continue to point next node until n is zero
            current = current.next;
        }
        
        if(current == null){
            return head.next;           // head is the actual target node that needs to be delete
        }
        
        prevToTarget = head;
        
        while(current.next != null){    // sliding node that comes before the actual target as we traverse
            current = current.next;
            prevToTarget = prevToTarget.next;
        }
        
        prevToTarget.next = prevToTarget.next.next;
    
        return head;           
    }
}
