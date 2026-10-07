class Solution 
{
    public int[] maxDepthAfterSplit(String seq) 
    {
        int len = seq.length();
        int arr[] = new int[len];
        int c=0;

        for(int i=0;i<len-1;i++)
        {
            char ch1 = seq.charAt(i);
            char ch2 = seq.charAt(i+1);

            if(ch1=='(' && ch2=='(')
                arr[i]=c++;
            else
            if(ch1==')' && ch2==')')
                arr[i]=c--;
            else
                arr[i]=c;
        }

        arr[len-1]=0;
        for(int i=0;i<len;i++)
            arr[i]%=2;

        return arr;
    }
}