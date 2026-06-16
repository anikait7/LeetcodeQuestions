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
    public int pairSum(ListNode head) 
    {
        List<Integer> list = new ArrayList<>();
        int max=0;
        ListNode ptr = head;

        while(ptr!=null)
        {
            list.add(ptr.val);
            ptr=ptr.next;
        }

        for(int i=0;i<list.size()/2;i++)
            max=Math.max(max,list.get(i)+list.get(list.size()-1-i));

        return max;
    }
}