class Solution 
{
    public int maximizeExpressionOfThree(int[] nums) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min=nums[0];

        for(int i : nums)
        {
            min=Math.min(i,min);
            pq.add(i);
        }

        return pq.poll()+pq.poll()-min;
    }
}