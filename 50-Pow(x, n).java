class Solution {
    public double myPow(double x, int n) 
    {
        // Convert int to long
        // to safely handle Integer.MIN_VALUE
        long N = n;

        // Handle negative powers
        if(N < 0)
        {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    public double power(double x, long n)
    {
        // Base case
        if(n == 0)
        {
            return 1;
        }

        // Recursive call
        double half = power(x, n / 2);

        // Even power
        if(n % 2 == 0)
        {
            return half * half;
        }

        // Odd power
        else
        {
            return x * half * half;
        }
    }
}
