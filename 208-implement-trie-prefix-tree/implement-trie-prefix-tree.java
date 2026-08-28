/*
    This is the basics of TRIE. Most important question to understand the implementation
    There is a root pointer that can point to 26 childs -> 'a' to 'z'
    The second level again has 26 children each pointing from -> 'a' to 'z'
    .........
    These children are created when the letter comes otherwise the space will get wasted

    apple and application
    These share appl then brach to e,T and i,c,a.....(n,T)
    T-> refers to word ending 
    Due to the sharing of prefix, its saves lot of space and time. Very efficient
*/

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