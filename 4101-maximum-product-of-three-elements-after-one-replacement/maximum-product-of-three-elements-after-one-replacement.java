class Solution 
{
    public long maxProduct(int[] nums) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(Math.abs(nums[0]));      pq.add(Math.abs(nums[1]));

        for(int i=2;i<nums.length;i++)
        {
            pq.add(Math.abs(nums[i]));
            pq.poll();
        }

        return 1L*pq.poll()*pq.poll()*100000;
    }
}