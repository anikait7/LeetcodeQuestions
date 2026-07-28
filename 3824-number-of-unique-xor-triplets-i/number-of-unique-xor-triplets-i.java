class Solution 
{
    public int uniqueXorTriplets(int[] nums) 
    {
        if(nums.length==1)
            return 1;

        if(nums.length==2)
            return 2;

        int max=nums.length;        
        
        //Every new bit added gives rise to the whole set of no.
        /*
            1 to 9
            8 no. can be made (1 to 8)
            9 gives us a new bit and the other no.s bit can be used to set/unset the remaining bits
        */

        int x=0;
        for(int i=1; ;i++)
        {
            if(Math.pow(2,i)<=max)
                x=i+1;
            else
                break;
        }

        return (int)Math.pow(2,x);
    }
}