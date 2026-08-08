class Solution 
{
    public int[] validSequence(String word1, String word2) 
    {
        int n = word1.length();     int m = word2.length();
        int suffix[] = new int[n+1];

        int ans[] = new int[m];

        int ptr1=n-1;   int ptr2=m-1;
        while(ptr1>=0)
        {
            suffix[ptr1]=suffix[ptr1+1];

            if(ptr2==-1)
            {
                ptr1--;
                continue;
            }

            if(word1.charAt(ptr1)==word2.charAt(ptr2))
            {
                suffix[ptr1]++;
                ptr2--;
            }

            ptr1--;
        }

        ptr1=0;     ptr2=0;     boolean canChange=true;
        while(ptr1<n && ptr2<m)
        {
            if(word1.charAt(ptr1)==word2.charAt(ptr2))
            {
                ans[ptr2]=ptr1;
                ptr1++;     ptr2++;
            }
            else
            {
                if(canChange)
                {
                    int rem = m-ptr2-1;
                    if(suffix[ptr1+1]>=rem)
                    {
                        canChange=false;
                        ans[ptr2]=ptr1;
                        ptr2++;
                    }
                }
                
                ptr1++;
            }
        }

        if(ptr2<m)
            return new int[]{};
        else
            return ans;
    }
}