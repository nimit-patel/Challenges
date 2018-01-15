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
        head = head.next;                   // important to store the next as it will be head eventually
        
        while(current != null && current.next != null){        
            
            temp = current.next;            // stores the next node
            current.next = temp.next;       // current now points to node after the next node
            temp.next = current;            // the next node in original list node points to its head/previous node
            
            previous.next = temp;           
            
            previous = current;             // after swap current is previous node
            current = current.next;         // something after this can be null hence the condition
            
        }
        
        return head;
    }
}
