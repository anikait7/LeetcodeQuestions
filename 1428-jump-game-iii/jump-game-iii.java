class Solution 
{
    int visited[];

    public boolean recursive(int arr[], int ind)
    {
        if(ind<0 || ind>=arr.length)
            return false;

        if(arr[ind]==0)
            return true;

        if(visited[ind]==0)
        {
            visited[ind]=1;

            if(recursive(arr,ind+arr[ind]))
                return true;

            if(recursive(arr,ind-arr[ind]))
                return true;
        }

        return false;
    }

    public boolean canReach(int[] arr, int start) 
    {
        int n = arr.length;
        visited = new int[n];
        //0 = not visited   1 = in progress

        return recursive(arr, start);
    }
}