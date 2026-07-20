class Solution 
{
    public String removeDuplicateLetters(String s) 
    {
        boolean visited[] = new boolean[26];
        StringBuilder sb = new StringBuilder();

        //last occurance of each character
        int last[] = new int[26];

        for(int i=0;i<s.length();i++)
            last[s.charAt(i)-'a']=i;

        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            int x = ch-'a';

            if(visited[x])
                continue;
                                   // current element in stack is bigger and appears later so remove it to make it lexographically smallest
            while(!stack.isEmpty() && stack.peek()>ch && last[stack.peek()-'a']>i)
                visited[stack.pop()-'a']=false;

            stack.push(ch);
            visited[x]=true;
        }

        for(char c : stack)
            sb.append(c);

        return sb.reverse().toString();
    }
}

/*       01234567890123456789012345
        "thesqtitxyetpxloeevdeqifkz"

d   e   f    h   i    k   l    o   p   q    s   t   v   x   y   z
19  20  23   1   22   24  14   15  12  21   3   11  18  13  9   25
*/