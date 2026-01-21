class Solution 
{
    public int[] minBitwiseArray(List<Integer> nums) 
    {
        int n = nums.size();
        int ans[] = new int[n];

        for(int i=0;i<n;i++)
        {
            if(nums.get(i)==2)
                ans[i]=-1;
            else
            {
                int arr[] = new int[32]; 
                int val=1;

                for(int j=31;j>=0;j--)
                {
                    int x = nums.get(i) & val;
                    if(x!=0)
                        arr[j]=1;
                    val<<=1;
                }

                for(int j=31;j>=0;j--)
                {
                    if(arr[j]==0)
                    {
                        arr[j+1]=0;
                        break;
                    }
                }

                int answer=0;
                for(int j=0;j<32;j++)
                    answer+=arr[j]*Math.pow(2,31-j);

                ans[i]=answer;
            }
        }

        return ans;
    }
}
