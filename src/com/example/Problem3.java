package com.example;

import java.util.Vector;

/**
 * Created by george on 5/22/15.
 *
 * Prime Factorizes a given number
 * Outputs the Prime factors
 */
public class Problem3
{
    public static Vector< Long > factors = new Vector<>(1, 3);           /* Holds the prime factors */
    public static long orig;

    /**
     * Converts a positive long represented in string format to an long
     *
     * @param argument The string to convert to int
     * @return An long which was represented by the string
     */
    public static long PosStringToLong( String argument )
    {
        long n = 0;

        int base = argument.length() - 1;
        for( int i = 0; i < argument.length(); i++ )
        {
            int num = argument.charAt( i ) - 48;

            if( num >= 0 && num <= 9 )
            {
                n += (long)num * Math.pow( 10, base );
                base--;
            }
            else        // Not a long
            {
                return -1L;
            }
        }

        return n;
    }

    /**
     * Determines whether n is prime or not
     *
     * @param n Determines whether n is a prime
     * @return Whether n is prime
     */
    public static boolean isPrime( long n )
    {
        // Check if divisible by 2
        if( (n & 1L) == 0L )
        {
            return false;
        }

        // Check if divisible by any other odd number
        long count = 3L;
        while( count <= n / 2L )
        {
            if( n % count == 0L )
            {
                return false;
            }

            count += 2L;
        }

        return true;
    }

    /**
     * Finds the next prime after n
     * @param n The last prime number found.
     * @return The next prime number.
     */
    public static long findNextPrime( long n )
    {
        // Edge Case: 2
        if( n == 2 )
            return 3;

        do
        {
            n += 2;
        } while( !isPrime( n ) );

        return n;
    }

    public static void main(String[] args)
    {
        // Edge Case: No input
        if( args.length == 0 )
        {
            System.out.println( "Error! Run program with a long to prime factorize.");
            return;
        }

        long num = PosStringToLong( args[0] );
        orig = num;

        // Edge Case: Not a long
        if( num < 0L )
        {
            System.out.println( "Error! Input is not a long!");
            return;
        }

        // Find factors of num
        long prime = 2L;
        while( prime <= num / 2L )
        {
            if( num % prime == 0 )
            {
                num /= prime;
                factors.add( prime );
            }
            else
            {
                prime = findNextPrime( prime );
            }
        }

        // Add last factor
        factors.add( num );

        System.out.print("The prime factors of " + orig + " are - ");
        for( long factor : factors )
        {
            System.out.print(factor + " ");
        }
    }
}
