class Solution 
{
    public List<List<Integer>> minimumAbsDifference(int[] arr) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int diff = arr[1]-arr[0];

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-arr[i-1]==diff)
            {
                List<Integer> temp = Arrays.asList(arr[i-1],arr[i]);
                ans.add(temp);
            }
            else
            if(arr[i]-arr[i-1]<diff)
            {
                diff=arr[i]-arr[i-1];
                ans = new ArrayList<>();
                List<Integer> temp = Arrays.asList(arr[i-1],arr[i]);
                ans.add(temp);
            }
        }

        return ans;
    }
}