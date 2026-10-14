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
    public Node flatten(Node head) {
        Node temp = head;
        while(temp != null){
            if(temp.child != null){
                Node curr = temp;
                Node nextNode = curr.next;
                Node childHead = curr.child;
                Node childTail = curr.child;
                while(childTail.next != null) childTail = childTail.next;
                curr.next = childHead;
                childHead.prev = curr;

                if(nextNode != null){
                    childTail.next = nextNode;
                    nextNode.prev = childTail;
                }
                curr.child = null;
            }
            temp = temp.next;     
        }
        return head;
    }
}