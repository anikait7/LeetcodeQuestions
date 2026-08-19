class Solution 
{
    public int maximumLengthSubstring(String s) 
    {
        int freq[] = new int[26];

        int max=Math.min(2,s.length());
        int ptr=0;

        for(int i=0;i<s.length();i++)
        {
            int x = s.charAt(i)-'a';
            freq[x]++;

            if(freq[x]>2)
            {
                max=Math.max(max,i-ptr);

                while(ptr<i)
                {
                    int y = s.charAt(ptr)-'a';
                    freq[y]--;
                    ptr++;
                    if(x==y)
                        break;
                }
            }
        }

        return Math.max(max,s.length()-ptr);
    }
}