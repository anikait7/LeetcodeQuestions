class Solution 
{
    public int countPrimeSetBits(int left, int right) 
    {
        Set<Integer> set = Set.of(2,3,5,7,11,13,17,19,23,29);
        int count=0;

        for(int i=left;i<=right;i++)
        {
            if(set.contains(Integer.bitCount(i)))
                count++;
        }

        return count;
    }
}