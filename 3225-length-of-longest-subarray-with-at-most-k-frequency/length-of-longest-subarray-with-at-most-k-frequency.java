class Solution 
{
    public int maxSubarrayLength(int[] nums, int k) 
    {
        int max=k;
        int ptr=0;
        int right=0;

        Map<Integer,Integer> map = new HashMap<>();
        while(right<nums.length)
        {
            if(map.containsKey(nums[right]))
            {
                if(map.get(nums[right])==k)
                {
                    max=Math.max(max,right-ptr);

                    while(nums[ptr]!=nums[right])
                    {
                        map.put(nums[ptr],map.get(nums[ptr])-1);
                        ptr++;
                    }

                    ptr++;
                }
                else
                    map.put(nums[right],map.get(nums[right])+1);
            }
            else
                map.put(nums[right],1);

            right++;
        }

        return Math.max(max,nums.length-ptr);
    }
}