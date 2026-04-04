class Solution 
{
    public String decodeCiphertext(String encoded, int rows) 
    {
        StringBuilder sb = new StringBuilder();

        int len = encoded.length();
        int r = rows;
        int c = len/r;

        char arr[][] = new char[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int num = i*c+j;
                arr[i][j]=encoded.charAt(num);
            }
        }

        for(int i=0;i<c;i++)
        {
            int count=0;
            for(int j=0;j<r && i+count<c;j++)
            {
                sb.append(arr[j][i+count++]);
            }
        }

        return sb.toString().stripTrailing();
    }
}