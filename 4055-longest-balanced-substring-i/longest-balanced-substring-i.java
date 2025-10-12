class Solution 
{
    public int longestBalanced(String s) 
    {
        int max=0;

        for(int i=0;i<s.length()-max;i++)
        {
            int freq[] = new int[26];

            for(int j=i;j<s.length();j++)
            {
                freq[s.charAt(j)-'a']++;
                int match = freq[s.charAt(i)-'a'];
                boolean flag=true;
                int c=0;

                for(int k=0;k<26;k++)
                {
                    if(freq[k]==0)
                        continue;
                    else
                    if(freq[k]!=match)
                    {
                        flag=false;
                        k=27;
                    }

                    c++;
                }

                if(flag)
                    max=Math.max(max,match*c);
            }
        }

        return max;
    }
}