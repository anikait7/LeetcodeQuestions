class Solution 
{
    public int totalWaviness(int num1, int num2) 
    {
        int start = Math.max(101,num1);
        int count=0;

        for(int i=start;i<=num2;i++)
        {
            String st = Integer.toString(i);
            int a[] = new int[st.length()];

            for(int j=0;j<st.length();j++)
                a[j]=st.charAt(j)-'0';            

            for(int j=1;j<st.length()-1;j++)
            {
                if((a[j]>a[j-1] && a[j]>a[j+1]) || (a[j]<a[j-1] && a[j]<a[j+1]))
                    count++;
            }
        }

        return count;
    }
}