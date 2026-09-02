class XYZ
{
    int len;    int max_freq;    int first_ele_freq;    int last_ele_freq;
    char first_char;     char last_char;

    //Cant store word because it will cause TLE (concatenation of string is O(n) repeated concatenation makes it slow)
    XYZ()
    {
        first_char=last_char=' ';
        len=0;
        max_freq=first_ele_freq=last_ele_freq=0;
    }

    XYZ(int len, char first_char, char last_char, int max_freq, int first_ele_freq, int last_ele_freq)
    {
        this.len=len;
        this.first_char=first_char;
        this.last_char=last_char;
        this.max_freq = max_freq;
        this.first_ele_freq = first_ele_freq;
        this.last_ele_freq = last_ele_freq;
    }
}

class Solution 
{
    public void buildTree(XYZ arr[], int index)
    {
        while(index>0)
        {
            //extracting value
            XYZ a = arr[index*2];
            XYZ b = arr[index*2+1];

            //do operation

            int x = a.len;
            int y = b.len;

            int max_freq=1;   int first_freq=a.first_ele_freq;   int last_freq=b.last_ele_freq;

            if(x>0 && y>0 && a.last_char==b.first_char)
                max_freq = a.last_ele_freq + b.first_ele_freq;

            max_freq = Math.max(max_freq,Math.max(a.max_freq,b.max_freq));

            //                   all element same in a      checking if a matches with first_char_b
            if(x>0 && y>0 && a.first_ele_freq==x && a.first_char==b.first_char)
                first_freq+=b.first_ele_freq;

            // all element same in b      checking if b matches with last_char_a
            if(x>0 && y>0 && b.last_ele_freq==y && a.last_char==b.first_char)
                last_freq+=a.last_ele_freq;

            //assign the value and move to the next index
            XYZ ans = new XYZ(x+y,a.first_char,b.last_char,max_freq,first_freq,last_freq);
            arr[index]=ans; 
            index--;
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) 
    {
        int len = s.length();

        int x=1;
        while(x<len)
            x*=2;

        int tree_len=2*x;

        XYZ arr[] = new XYZ[tree_len];

        int start=x;

        //building the leaf nodes
        for(int i=0;i<len;i++)
        {
            char ch = s.charAt(i);
            arr[start+i] = new XYZ(1,ch,ch,1,1,1);
        }

        for(int i=start+len;i<tree_len;i++)
            arr[i]= new XYZ();

        //building the segment tree
        buildTree(arr,start-1);

        int n = queryIndices.length;
        int ans[] = new int[n];

        for(int i=0;i<n;i++)
        {
            //update query
            char ch = queryCharacters.charAt(i);

            int index=start+queryIndices[i];
            arr[index] = new XYZ(1,ch,ch,1,1,1);

            //build
            while(index>1)
            {
                index/=2;
                XYZ a = arr[index*2];
                XYZ b = arr[index*2+1];

                //do operation

                int xx = a.len;
                int yy = b.len;

                int max_freq=1;   int first_freq=a.first_ele_freq;   int last_freq=b.last_ele_freq;

                if(xx>0 && yy>0 && a.last_char==b.first_char)
                    max_freq = a.last_ele_freq + b.first_ele_freq;

                max_freq = Math.max(max_freq,Math.max(a.max_freq,b.max_freq));

                // all element same in a      checking if a matches with first_char_b
                if(xx>0 && yy>0 && a.first_ele_freq==xx     && a.first_char==b.first_char)
                    first_freq+=b.first_ele_freq;

                // all element same in b      checking if b matches with last_char_a
                if(xx>0 && yy>0 && b.last_ele_freq==yy     && a.last_char==b.first_char)
                    last_freq+=a.last_ele_freq;

                //assign the value and move to the next index
                XYZ ansans = new XYZ(xx+yy,a.first_char,b.last_char,max_freq,first_freq,last_freq);
                arr[index]=ansans; 
            }

            //root is the answer
            ans[i]=arr[1].max_freq;
        }

        return ans;
    }
}

/*
    b   a   b   a   c   c   c   ""
every node will have four things -> 
    string appended, maximum continuous frequency, last_element continuous count, first_element continuous count
        (String)        (int)                       (int)                           (int)

    on merging two nodes (left + right)
    
    FOR NODE
    string appended = left+right
    maximum continuos frequency = (left_max, right_max, check if left_lastchar = right_firstchar)
                                                        left.last_element_continuous_count + right.first_element_continuous_count
    last similar suffix = right suffix
*/