class Solution 
{
    public int totalWaviness(int num1, int num2) 
    {
        int start = Math.max(101,num1);
        int count=0;

        for(int i=start;i<=num2;i++)
        {
            char a[] = Integer.toString(i).toCharArray();

            for(int j=1;j<a.length-1;j++)
            {
                if((a[j]>a[j-1] && a[j]>a[j+1]) || (a[j]<a[j-1] && a[j]<a[j+1]))
                    count++;
            }
        }

        return count;
    }
}