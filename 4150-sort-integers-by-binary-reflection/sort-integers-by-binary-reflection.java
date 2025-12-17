class Solution 
{
    public int[] sortByReflection(int[] nums) 
    {
        int n = nums.length;
        int arr[][] = new int[n][2];

        for(int i=0;i<n;i++)
        {
            arr[i][0]=nums[i];
            int x = nums[i];
            
            StringBuilder sb = new StringBuilder();
            while(x>0)
            {
                sb.append(x%2);
                x/=2;
            }

            int num = Integer.parseInt(sb.toString(),2);
            arr[i][1]=num;
        }

        Arrays.sort(arr, (a,b) -> (a[1]!=b[1]) ? a[1]-b[1] : a[0]-b[0]);

        int ans[] = new int[n];
        for(int i=0;i<n;i++)
            ans[i]=arr[i][0];

        return ans;
    }
}