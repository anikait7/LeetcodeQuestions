//declaration of custom class variable
class Trie
{
    boolean isLast; //check if the element has ended or not
    Trie arr[] = new Trie[26]; //one route each for next alphabet from 'a' to 'z'

    int count=0; //checking how many words use the same path. Later will help to delete the word once found optimizing time complexity
    String word; //the word that we made into trie form isLast=true then we store word
}

class Solution 
{
    List<String> ans = new ArrayList<>(); //storing the final result
    Trie root = new Trie();
    int r;
    int c;

    //building of Trie
    public void buildTrie(String st)
    {
        Trie temp = root;
        temp.count++;

        for(int i=0;i<st.length();i++)
        {
            int ch = st.charAt(i)-'a';
            if(temp.arr[ch]==null)
                temp.arr[ch] = new Trie();

            temp=temp.arr[ch];
            temp.count++;
        }

        temp.isLast=true;
        temp.word=st;
    }

    public void dfs(boolean visited[][], char board[][], int x, int y, Trie temp)
    {
        if(temp==null) //|| temp.count==0
            return ;

        int ch = board[x][y]-'a';

        if(temp.isLast==true)
        {
            ans.add(temp.word);
            temp.isLast=false;  

            // if(temp.count==1)
            //     return ;
            //now we need to delete the existing word since its found -> by reducing the count
            /* 
            -----deletion code -----

            if(temp.count==0)
                return ;
            */

            //there is a possibility of having two words apple and app. We will encounter app first but the issue -> we need to look if we can also find apple hence we cant stop here itself we need to do normal dfs again even though we found a word hoping that we find a word later again   
        }

        if(x>0 && !visited[x-1][y])
        {
            visited[x-1][y]=true;
            int ch1 = board[x-1][y]-'a';
            dfs(visited,board,x-1,y,temp.arr[ch1]);
            visited[x-1][y]=false;
        }

        if(y>0 && !visited[x][y-1])
        {
            visited[x][y-1]=true;
            int ch1 = board[x][y-1]-'a';
            dfs(visited,board,x,y-1,temp.arr[ch1]);
            visited[x][y-1]=false;
        }

        if(x+1<r && !visited[x+1][y])
        {
            visited[x+1][y]=true;
            int ch1 = board[x+1][y]-'a';
            dfs(visited,board,x+1,y,temp.arr[ch1]);
            visited[x+1][y]=false;
        }

        if(y+1<c && !visited[x][y+1])
        {
            visited[x][y+1]=true;
            int ch1 = board[x][y+1]-'a';
            dfs(visited,board,x,y+1,temp.arr[ch1]);
            visited[x][y+1]=false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) 
    {
        //building trie for every search word
        for(int i=0;i<words.length;i++)
            buildTrie(words[i]);

        r = board.length;      c = board[0].length;

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                Trie xyz = root;
                int ch = board[i][j]-'a';

                if(xyz.arr[ch]==null)
                    continue;

                boolean visited[][] = new boolean[r][c]; 
                visited[i][j]=true;   

                dfs(visited,board,i,j,xyz.arr[ch]);                
            }
        }

        return ans;
    }
}