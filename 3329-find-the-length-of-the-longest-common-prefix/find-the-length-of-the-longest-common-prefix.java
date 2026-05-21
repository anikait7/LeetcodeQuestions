class Solution 
{
    public int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
        String x[] = new String[arr1.length];
        String y[] = new String[arr2.length];
        int max=0;

        for(int i=0;i<arr1.length;i++)
            x[i]=Integer.toString(arr1[i]);

        for(int i=0;i<arr2.length;i++)
            y[i]=Integer.toString(arr2[i]);

        Arrays.sort(x);
        Arrays.sort(y);

        int ptr1=0; int ptr2=0;
        //increase the smaller one
        while(ptr1<x.length && ptr2<y.length)
        {
            int i=0;    
            while(i<Math.min(x[ptr1].length(),y[ptr2].length()))
            {
                if(x[ptr1].charAt(i)==y[ptr2].charAt(i))
                    i++;
                else
                    break;
            }

            max=Math.max(max,i);
            if(x[ptr1].equals(y[ptr2]))
            {
                ptr1++;             ptr2++;
            }
            else
            if(x[ptr1].compareTo(y[ptr2])<0)
                ptr1++;
            else
                ptr2++;
        }

        return max;
    }
}