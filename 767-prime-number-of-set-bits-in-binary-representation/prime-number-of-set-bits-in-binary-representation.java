class Solution 
{
    public int countPrimeSetBits(int left, int right) 
    {
        Set<Integer> set = Set.of(2,3,5,7,11,13,17,19,23,29);
        int count=0;

        for(int i=left;i<=right;i++)
        {
            int c=0;          int num=i;

            while(num>0)
            {
                if((num&1)==1)
                    c++;

                num>>=1;
            }

            if(set.contains(c))
                count++;
        }

        return count;
    }
}