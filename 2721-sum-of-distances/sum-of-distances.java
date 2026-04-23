class Solution 
{
    public long[] distance(int[] nums) 
    {
        int len = nums.length;
        long ans[] = new long[len];

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<len;i++)
            map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
        
        for(List<Integer> list : map.values())
        {
            long prefix[] = new long[list.size()+1];
            for(int i=0;i<list.size();i++)
                prefix[i+1]=prefix[i]*1L+list.get(i);

            for(int i=0;i<list.size();i++)
            {
                long x = list.get(i);
                long left = x*i-prefix[i];
                long right = prefix[list.size()]-prefix[i+1] - x*(list.size()-i-1);

                ans[(int)x] = right+left;
            }
        }
        
        return ans;
    }
}