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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<lists.length;i++)
        {
            ListNode ptr = lists[i];
            while(ptr!=null)
            {
                pq.add(ptr.val);
                ptr=ptr.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode ptr=dummy;

        while(!pq.isEmpty())
        {
            ListNode temp = new ListNode(pq.poll());
            ptr.next=temp;
            ptr=ptr.next;
        }

        return dummy.next;
    }
}