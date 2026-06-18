class Solution 
{
    public double angleClock(int hour, int minutes) 
    {
        hour%=12;

        double m_handle = minutes*6;
        double h_handle = hour*5*6+0.5*minutes;

        double diff = Math.abs(m_handle-h_handle);

        return Math.min(diff,360-diff);
    }
}