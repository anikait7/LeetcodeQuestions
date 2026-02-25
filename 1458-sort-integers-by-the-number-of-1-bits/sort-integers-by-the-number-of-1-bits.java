class Solution 
{
    public int[] sortByBits(int[] arr) 
    {
        int array[][] = new int[arr.length][2];

        for(int i=0;i<arr.length;i++)
        {
            int c=0;
            array[i][0]=arr[i];
            while(arr[i]>0)
            {
                if((arr[i]&1)==1)
                    c++;

                arr[i]>>=1;
            }
            array[i][1]=c;
        }

        Arrays.sort(array, (a,b) -> 
            {
                if(a[1]!=b[1])
                    return a[1]-b[1];

                return a[0]-b[0];
            }
        );

        for(int i=0;i<arr.length;i++)
            arr[i]=array[i][0];

        return arr;
    }
}