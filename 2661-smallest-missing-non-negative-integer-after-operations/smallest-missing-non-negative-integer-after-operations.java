class Solution 
{
    public int findSmallestInteger(int[] nums, int val) 
    {
        int arr[] = new int[val];

        for(int i : nums)
        {
            int r = i%val;
            if(r<0)
                r+=val;

            arr[r]++;
        }

        int ans=0;

        while(true)
        {
            if(arr[ans%val]>0)
                arr[ans%val]--;
            else
                break;

            ans++;
        }

        return ans;
    }
}