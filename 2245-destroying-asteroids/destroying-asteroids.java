class Solution 
{
    public boolean asteroidsDestroyed(int mass, int[] asteroids) 
    {
        Arrays.sort(asteroids);
        long m = mass*1L;

        for(int i=0;i<asteroids.length;i++)
        {
            if(m<asteroids[i])
                return false;

            m+=asteroids[i];
        }

        return true;
    }
}