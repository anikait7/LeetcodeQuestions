class Solution 
{
    Map<Character, int[]> map = new HashMap<>();
    int dp[][][];

    public int recursive(char finger1, char finger2, int index, String word)
    {
        //base case 
        if(index<0)
            return 0;

        if(dp[index][finger1-'A'][finger2-'A']!=-1)
            return dp[index][finger1-'A'][finger2-'A'];

        char ch =word.charAt(index);
        int dist[] = map.get(ch);

        int temp1[] = map.get(finger1);
        int temp2[] = map.get(finger2);

        int dist1 = Math.abs(dist[0]-temp1[0])+Math.abs(dist[1]-temp1[1]);
        int dist2 = Math.abs(dist[0]-temp2[0])+Math.abs(dist[1]-temp2[1]);

        //make finger1 =ch
        int move1 = dist1 + recursive(ch,finger2,index-1,word);

        //make finger2=ch
        int move2 = dist2 + recursive(finger1,ch,index-1,word);
        
        return dp[index][finger1-'A'][finger2-'A']=Math.min(move1,move2);
    }

    public int minimumDistance(String word) 
    {
        for(int i=0;i<26;i++)
        {
            int x = i/6;
            int y = i-x*6;

            map.put((char)(65+i),new int[]{x,y});
        }

        char finger1 = word.charAt(word.length()-1);
        int min = Integer.MAX_VALUE;

        //no of last element + finger1 + finger2
        dp = new int[word.length()][26][26];

        for(int i=0;i<word.length();i++)
            for(int j=0;j<26;j++)
                Arrays.fill(dp[i][j],-1);

        for(int i=65;i<=90;i++)
        {
            char finger2 = (char)(i);
            min = Math.min(min,recursive(finger1,finger2,word.length()-1,word));
        }

        return min;
    }
}