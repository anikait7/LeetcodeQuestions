import java.util.*;
class Solution 
{
    public int maxDistinctElements(int[] nums, int k) 
    {
        Arrays.sort(nums);
        int prev=nums[0]-k;
        int count=1;

        for(int i=1;i<nums.length;i++)
        {
            int curr=nums[i]-k;
            if(curr<=prev)
            {
                prev=prev+1;
                if(prev<=nums[i]+k)
                    count++;
                else
                    prev--;
            }
            else
            {
                count++;
                prev=curr;
            }
        }

        return count;
    }
}