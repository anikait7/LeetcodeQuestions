class Solution 
{
    public int[] pivotArray(int[] nums, int pivot) 
    {
        int y=0;
        List<Integer> x = new ArrayList<>();
        List<Integer> z = new ArrayList<>();

        for(int val : nums)
        {
            if(val<pivot)
                x.add(val);
            else
            if(val>pivot)
                z.add(val);
            else
                y++;
        }

        int c=0;
        for(int i=0;i<x.size();i++)
            nums[c++]=x.get(i);

        for(int i=0;i<y;i++)
            nums[c++]=pivot;

        for(int i=0;i<z.size();i++)
            nums[c++]=z.get(i);

        return nums;
    }
}