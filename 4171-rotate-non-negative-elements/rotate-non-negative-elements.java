class Solution 
{
    public int[] rotateElements(int[] nums, int k) 
    {
        List<Integer> list = new ArrayList<>();

        for(int i : nums)
            if(i>=0)
                list.add(i);

        if(list.size()==0)
            return nums;

        k = list.size()-k%list.size(); //converting to right NOT LEFT
        int arr[] = new int[list.size()];

        for(int i=0;i<list.size();i++)
        {
            arr[(i+k)%list.size()]=list.get(i);
        }

        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=0)
                nums[i]=arr[c++];
        }

        return nums;
    }
}