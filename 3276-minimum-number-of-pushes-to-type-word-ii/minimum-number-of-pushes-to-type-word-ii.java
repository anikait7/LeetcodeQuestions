class Solution 
{
    public int minimumPushes(String word) 
    {
        int ind=1,sum=0,count=1;
        int a[] = new int[26];

        for(char c:word.toCharArray())
            a[c-'a']++;
        
        Arrays.sort(a);
        
        for(int i=25;i>=0 && a[i]!=0;i--)
        {                
            if(ind>8)
            {
                count++;
                ind=1;
            }

            sum+=a[i]*count;
            ind++;
        }

        return sum;
    }
}