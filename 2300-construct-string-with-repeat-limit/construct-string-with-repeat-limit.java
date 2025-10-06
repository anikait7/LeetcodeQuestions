class Solution 
{
    public String repeatLimitedString(String s, int repeat) 
    {
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;

        StringBuilder sb = new StringBuilder();
        while(true)
        {
            int pos=-1;
            for(int i=25;i>=0;i--)
                if(freq[i]>0)
                {   
                    pos=i;
                    break;
                }            

            if(pos==-1)
                break;

            if(freq[pos]>repeat)
            {
                for(int j=1;j<=repeat;j++)
                    sb.append((char)('a'+pos));

                freq[pos]-=repeat;
                
                for(int j=pos-1;j>=-1;j--)
                {
                    if(j==-1)
                        return sb.toString();
                    else
                    if(freq[j]>0)
                    {
                        sb.append((char)('a'+j));
                        freq[j]--;
                        break;
                    }
                }
            }
            else
            {
                for(int j=1;j<=freq[pos];j++)
                    sb.append((char)('a'+pos));
                
                freq[pos]=0;
            }                
        }

        return sb.toString();
    }
}