class Solution 
{
    public int[] getSneakyNumbers(int[] nums) 
    {
        int i,j,c=0;
        int a[] = new int[2];

        for(i=0;i<nums.length-1;i++)
        {
            for(j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    a[c++]=nums[i];
                    break;
                }
            }
            if(c==2)
                break;
        }
        return a;
    }
}