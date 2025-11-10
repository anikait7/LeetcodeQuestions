class Solution 
{
    public List<Integer> findMissingElements(int[] nums) 
    {
        int min=101;    int max=-1;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i : nums)
        {
            set.add(i);
            min=Math.min(min,i);
            max=Math.max(max,i);
        }

        for(int i=min+1;i<max;i++)
            if(!set.contains(i))
                list.add(i);

        return list;
    }
}