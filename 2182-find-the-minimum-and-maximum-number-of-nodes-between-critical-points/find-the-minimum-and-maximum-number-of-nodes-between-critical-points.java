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
    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        int ans[] = new int[2];
        ans[0]=ans[1]=-1;

        List<Integer> index = new ArrayList<>();

        int a=head.val;
        head=head.next;

        int b = head.val;
        int ind=1;

        while(head.next!=null)
        {
            int c = head.next.val;

            if((a<b && b>c) || (a>b && b<c))
            {
                index.add(ind);
            }

            ind++;
            head=head.next;

            a=b;
            b=c;
        }

        if(index.size()<=1)
            return ans;

        ans[0]=ans[1]=index.get(index.size()-1)-index.get(0);

        for(int i=1;i<index.size();i++)
            ans[0]=Math.min(ans[0],index.get(i)-index.get(i-1));

        return ans; 
    }
}