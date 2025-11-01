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
    public ListNode modifiedList(int[] nums, ListNode head) 
    {
        Set<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);

        ListNode start=null;
        ListNode ptr=start;

        while(head!=null)
        {
            int val = head.val;
            if(!set.contains(val))
            {
                if(ptr==null)
                {
                    ptr=head;
                    head=head.next;
                    ptr.next=null;
                    start=ptr;
                }
                else
                {
                    ptr.next=head;
                    head=head.next;
                    ptr=ptr.next;
                    ptr.next=null;
                }
            }
            else
                head=head.next;
        }

        return start;
    }
}