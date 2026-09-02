class Solution 
{
    public boolean uniformArray(int[] nums1) 
    {
        int n = nums1.length;

        if(n==1)
            return true;

        int odd=0;

        for(int i : nums1)
            if(i%2==1)
                odd++;

        int even = n-odd;

        
        
        return true;
    }
}