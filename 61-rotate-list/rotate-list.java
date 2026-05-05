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
class Solution 
{
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null)
            return head;

        int len=0;
        ListNode ptr=head;

        while(ptr!=null)
        {
            ptr=ptr.next;
            len++;
        }

        k=k%len;
        if(k==0)
            return head;
        int find=len-k-1;
        len=0;

        ptr=head;
        while(len!=find)
        {
            ptr=ptr.next;
            len++;
        }

        ListNode ans1=ptr.next;
        ptr.next=null;

        ptr=ans1;
        while(ptr.next!=null)
            ptr=ptr.next;

        ptr.next=head;

        return ans1;
    }
}