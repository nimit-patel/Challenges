/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode previous = new ListNode(0); // dummy, trick to avoid code repetition
        ListNode temp = null;
        ListNode current = head;
        head = head.next; // important to store the next as it will be head eventually
        
        /*
        temp = current.next; 
        current.next = temp.next; // 1,2,3 1 points directly to 3 and 2 gets stored in temporary
        temp.next = current;            // 2 now gets directly connected to 1
        previous = current;         // previous node is 2
        current = current.next;         // current is at 3 now
        */
        
        while(current != null && current.next != null){        // 1,2,3,4
            
            temp = current.next;            // stores 4 and on
            current.next = temp.next;       // 3 points to somethig after 4
            temp.next = current;            // 4 now points to 3
            
            previous.next = temp;           // finally 2 connects to 4
            
            previous = current;             // now previous is 3, after swap current is previous node
            current = current.next;         // something after 3 can be null
            
        }
        
        return head;
    }
}
