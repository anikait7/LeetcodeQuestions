class Solution 
{
    public String lexPalindromicPermutation(String s, String target) 
    {
        int n = s.length();

        int ans[] = new int[s.length()];
        Arrays.fill(ans,-1);

        int freq[] = new int[26];

        int count=0;      int last=-1;

        for(int i=0;i<n;i++)
            freq[s.charAt(i)-'a']++;

        for(int i=0;i<26;i++)
        {
            if(freq[i]%2==1)
            {
                last=i;
                count++;
            }
        }

        if(count>1)
            return "";
        else
        if(count==1)
        {
            freq[last]--;
            ans[n/2]=last;
        }

        String st="";
        StringBuilder sb = new StringBuilder();
        boolean completed=true;

        for(int i=0;i<n/2;i++)
        {
            //replace it with the next character

            int ch = target.charAt(i)-'a';
            int found=-1;

            for(int j=ch+1;j<26;j++)
            {
                if(freq[j]>=2)
                {
                    found=j;
                    break;
                }
            }

            if(found!=-1)
            {
                sb = new StringBuilder();
                freq[found]-=2;
                int temp[] = ans.clone();

                int c=i+1;
                temp[i]=temp[n-1-i]=found;

                for(int j=0;j<26;j++)
                {
                    int copy=freq[j];
                    while(copy>0)
                    {
                        copy-=2;
                        temp[c]=temp[n-1-c++]=j;
                    }
                }

                for(int j=0;j<n;j++)
                    sb.append((char)('a'+temp[j]));

                String xyz=sb.toString();
                if(st.equals("") || xyz.compareTo(st)<0)
                    st=xyz;

                freq[found]+=2;
            }

            //continue with the same character and hope to get better result in the future
            if(freq[ch]<2)
            {
                completed=false;
                break;
            }

            freq[ch]-=2;
            ans[i]=ans[n-1-i]=ch;
        }

        if(completed)
        {
            sb = new StringBuilder();

            for(int j=0;j<n;j++)
                sb.append((char)('a'+ans[j]));

            String exact = sb.toString();
            if(exact.compareTo(target)>0 && (st.equals("") || exact.compareTo(st)<0))
                st=exact;
        }

        return st;
    }
}