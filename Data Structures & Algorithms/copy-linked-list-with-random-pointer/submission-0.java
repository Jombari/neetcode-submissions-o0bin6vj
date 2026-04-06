/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> oldToNew = new HashMap<>();

        Node curNode = head;
        Node prevNode = null;
        while(curNode != null){
            Node newNode = new Node(curNode.val);
            oldToNew.put(curNode,newNode);
            if(prevNode!=null){
                prevNode.next = newNode;
            }
            prevNode = newNode;
            curNode = curNode.next;
        }
        Node oldNode = head;
        while(oldNode != null){
            Node newNode = oldToNew.get(oldNode);
            newNode.random = oldToNew.get(oldNode.random);
            oldNode = oldNode.next;
        }
        return oldToNew.get(head);
    }
}
