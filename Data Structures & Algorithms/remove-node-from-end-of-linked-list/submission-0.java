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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        

        List<ListNode> nodes = new ArrayList<>();
        int count = 0;
        ListNode tmpNode = head;
        while(tmpNode != null){
            nodes.add(tmpNode);
            tmpNode = tmpNode.next;
            count++;
        }

        if(count-n-1 < 0)
            return head.next;
        else{
            ListNode cut = nodes.get(count-n-1);
            cut.next = cut.next.next;
        }
        return head;
    }
}
