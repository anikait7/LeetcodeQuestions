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
    public ListNode sortList(ListNode head) 
    {
        if(head==null)
            return head;
            
        ListNode ptr=head;
        List<Integer> list = new ArrayList<>();

        while(ptr!=null)
        {
            list.add(ptr.val);
            ptr=ptr.next;
        }

        Collections.sort(list);

        ListNode start = new ListNode(list.get(0));
        ptr=start;

        for(int i=1;i<list.size();i++)
        {
            ListNode temp = new ListNode(list.get(i));
            ptr.next=temp;
            ptr=ptr.next;
        }

        return start;
    }
}