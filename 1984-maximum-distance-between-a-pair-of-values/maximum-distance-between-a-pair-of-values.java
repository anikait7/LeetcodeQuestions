class Solution 
{
    public int maxDistance(int[] nums1, int[] nums2) 
    {
        int ans=0;

        for(int i=0;i<nums1.length;i++)
        {
            int lb=i;   int ub=nums2.length-1;

            while(lb<=ub)
            {
                int mid = (lb+ub)/2;
                if(nums1[i]<=nums2[mid])
                    lb=mid+1;
                else
                    ub=mid-1;
            }

            ans=Math.max(ans,ub-i);
        }

        return ans;
    }
}