/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    private Node helper(Node prev, Node curr) {
        if(curr == null)   return prev;

        prev.next = curr;
        curr.prev = prev;

        Node temp = curr.next;
        Node tail = helper(curr, curr.child);

        curr.child = null;
        return helper(tail, temp);

    } 

    public Node flatten(Node head) {
        if(head == null)       return null;

        Node prev = new Node(-1);
        prev.next = head;
        
        helper(prev, head);

        head.prev = null;
        return head;
    }
}