class Solution 
{
    public int search(int[] nums, int target) 
    {
        int n = nums.length;
        int lb=0;   int ub=n-1;

        while(lb<ub)
        {
            int mid = (lb+ub)/2;

            if(nums[mid]>nums[ub])
                lb=mid+1;
            else
                ub=mid;
        }

        int pivot = lb;
        int lb1, ub1;

        if(target>=nums[pivot] && target<=nums[n-1])
        {
            lb1=pivot;         ub1=n-1;
        }
        else
        {
            lb1=0;          ub1=pivot-1;
        }

        while(lb1<=ub1)
        {
            int mid = (lb1+ub1)/2;

            if(nums[mid] == target)
                return mid;
            else 
            if(nums[mid]<target)
                lb1=mid+1;
            else
                ub1=mid-1;
        }

        return -1;
    }
}