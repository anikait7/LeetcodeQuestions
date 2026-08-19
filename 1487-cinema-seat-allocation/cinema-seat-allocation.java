class Solution 
{
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) 
    {
        Map<Integer,Integer> map = new HashMap<>(); //1 to n && 1 to 10
        //1 -> reserved   0-> not reserved yet

        for(int temp[] : reservedSeats)
        {
            int row = temp[0];
            int col = temp[1];

            //bitwise manipulation for seats occupied
            if(col>=2 && col<=9)
                map.put(row,map.getOrDefault(row,0) | (1<<col));    
        }

        int count=(n-map.size())*2;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int val = entry.getValue();
            boolean left =   (val & (0b0000111100))==0;
            boolean middle = (val & (0b0011110000))==0;
            boolean right =  (val & (0b1111000000))==0;

            if(left && right)
                count+=2;
            else
            if(left || right || middle)
                count++;
        }

        return count;
    }
}