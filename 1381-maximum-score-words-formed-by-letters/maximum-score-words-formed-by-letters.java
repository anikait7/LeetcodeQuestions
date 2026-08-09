class Solution 
{
    int dp[];

    public int recursive(String words[], int freq[], int score[], int index)
    {
        if(index==words.length)
            return 0;

        //skip it
        int x = recursive(words,freq,score,index+1);

        int y=0;
        int temp[] = new int[26];
        
        for(int i=0;i<words[index].length();i++)
            temp[words[index].charAt(i)-'a']++;

        boolean canInclude=true;

        for(int i=0;i<26;i++)
            if(freq[i]-temp[i]<0)
                canInclude=false;

        if(canInclude)
        {
            int s=0;
            
            for(int i=0;i<26;i++)
            {
                freq[i]-=temp[i];
                s+=temp[i]*score[i];
            }

            y=s+recursive(words,freq,score,index+1);

            for(int i=0;i<26;i++)
            {
                freq[i]+=temp[i];
            }
        }
        
        return Math.max(x,y);
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) 
    {
        int freq[] = new int[26];
        dp = new int[words.length];
        Arrays.fill(dp,-1);

        for(int i=0;i<letters.length;i++)
            freq[letters[i]-'a']++;

        return recursive(words,freq,score,0);
    }
}