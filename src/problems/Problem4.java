package problems;

import java.util.Vector;

/**
 * Created by george on 5/23/15.
 *
 * Finds the largest palindrome made from the product of two 3-digit numbers
 */
public class Problem4
{
    /**
     * Determines whether n is a palindrome
     * @param n Number to test
     * @return Whether n is a palindrome
     */
    public static boolean isPalindrome( long n )
    {
        Vector< Integer > digits = new Vector < >(1, 2);

        while( n != 0 )
        {
            int temp = (int)(n % 10L);
            n /= 10L;

            digits.add(0, temp);
        }

        for( int i = 0; i < digits.size()/2; i++ )
        {
            int j = digits.size() - 1 - i;

            if( digits.elementAt(i) != digits.elementAt(j) )
                return false;
        }

        return true;
    }

    public static void main(String[] args)
    {

        long maxPalindrome = -1;

        for( long i = 100L; i < 1000L; i++ )
        {
            for( long j = i+1; j < 1000L; j++ )
            {
                long n = i*j;
                if( isPalindrome(n) && maxPalindrome < n )
                    maxPalindrome = n;
            }
        }

        System.out.println("The max palindrome of two 3-digit numbers is - " + maxPalindrome);
    }
}
