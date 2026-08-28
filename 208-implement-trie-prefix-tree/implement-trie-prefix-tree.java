class TrieNode
{
    TrieNode child[] = new TrieNode[26];
    boolean isEnd;
}

class Trie 
{
    TrieNode root;

    public Trie() 
    {
        root = new TrieNode();
    }
    
    public void insert(String word) 
    {
        TrieNode temp = root;

        for(int i=0;i<word.length();i++)
        {
            int ch = word.charAt(i)-'a';
            if(temp.child[ch]==null)
                temp.child[ch] = new TrieNode();

            temp = temp.child[ch];
        }

        temp.isEnd=true;
    }
    
    public boolean search(String word) 
    {
        TrieNode temp = root;

        for(int i=0;i<word.length();i++)
        {
            int ch = word.charAt(i)-'a';
            if(temp.child[ch]==null)
                return false;

            temp = temp.child[ch];
        }

        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) 
    {
        TrieNode temp = root;

        for(int i=0;i<prefix.length();i++)
        {
            int ch = prefix.charAt(i)-'a';
            if(temp.child[ch]==null)
                return false;

            temp = temp.child[ch];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */