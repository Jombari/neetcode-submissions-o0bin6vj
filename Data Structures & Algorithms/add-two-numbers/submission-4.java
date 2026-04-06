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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = sum%10;
            carry= sum /10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = sum %10;
            carry= sum/10;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val + carry;
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = sum%10;
            carry = sum/10;
            l2 = l2.next;
        }
        if(l1 == null && l2 == null && carry != 0){
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = carry;
        }

        return ans.next;
    }
}
