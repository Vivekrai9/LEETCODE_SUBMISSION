/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // head= head.next;
        int sum=0;

        while(head != null){

            if(head.val == 0){
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum=0;
            }
            else{
                sum += head.val;
            }

            head = head.next;

        }


        return dummy.next.next;
        
    }
}