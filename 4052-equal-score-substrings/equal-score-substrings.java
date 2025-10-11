class Solution 
{
    public boolean scoreBalance(String s) 
    {
        int n = s.length();
        int a[] = new int[n];
        int sum=0;  int left=0;

        for(int i=0;i<n;i++)
        {
            a[i]=s.charAt(i)-'a'+1;
            sum+=a[i];
        }

        for(int i=0;i<n;i++)
        {
            left+=a[i];
            if(sum-left==left)
                return true;
        }

        return false;
    }
}