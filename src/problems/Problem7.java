package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by george on 5/24/15.
 *
 * Calculates the nth prime
 */
public class Problem7
{
    /**
     * Finds the nth prime using the Sieve of Eratosthenes
     * @param n Self-explanatory
     * @return The nth prime
     */

    public static int findNthPrime( int n )
    {
        int capacity = n * (n/5) + 100;
        ArrayList<Integer> mark = new ArrayList<>(Collections.nCopies( capacity, -1 ));

        mark.set(0, 0);
        mark.set(1, 0);

        int prime = 0;
        while( n > 0 )
        {
            // Find next prime
            boolean found = false;
            while( !found )
            {
                if( mark.get(++prime) == -1 )
                {
                    mark.set( prime, 1 );
                    found = true;
                    n--;
                }
            }

            // Mark the multiples of prime
            for ( int i = prime; i < mark.size(); i += prime )
            {
                if( mark.get( i ) == -1 )
                {
                    mark.set( i, 0 );
                }
            }
        }

        return prime;
    }

    public static void main( String[] args )
    {

        /* Get the nth number */
        Scanner input = new Scanner( System.in );
        boolean invalid = true;
        int n = 1;

        while( invalid )
        {
            System.out.println("Which prime are you looking for?");
            n = input.nextInt();

            if( n > 0 )
            {
                invalid = false;
            }
            else
            {
                System.out.println( "Error! Please input a positive number" );
            }
        }

        int prime = findNthPrime( n );

        System.out.println( "The " + n + "th prime is " + prime );

    }

}
