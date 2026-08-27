class Solution 
{
    public String lexGreaterPermutation(String s, String target) 
    {
        int freq[] = new int[26];

        StringBuilder sb = new StringBuilder();
        String ans="";
        
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;

        for(int i=0;i<target.length();i++)
        {
            /*
                fix the ith character with 
                        a) the same character hoping you can form better lexiographical string
                        b) replace the character with next lexicographically character 
            */

            //replce the character with next 
            int ch = target.charAt(i)-'a';
            StringBuilder temp = new StringBuilder(sb.toString());
            int random=-1;

            for(int j=ch+1;j<26;j++)
            {
                if(freq[j]!=0)
                {
                    temp.append((char)('a'+j));
                    random=j;
                    freq[random]--;
                    break;
                }
            }

            if(random!=-1)
            {
                for(int j=0;j<26;j++)
                    temp.append(String.valueOf((char)('a'+j)).repeat(freq[j]));

                ans=temp.toString();
                freq[random]++;
            }            
            
            //hoping to find better in the next iteration
            if(freq[ch]>0)
                sb.append((char)('a'+ch));
            else
                return ans;

            freq[ch]--;
        }

        return ans;
    }
}