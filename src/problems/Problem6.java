package problems;

import java.util.Scanner;

/**
 * Created by george on 5/23/15.
 *
 * Finds the difference between the sum of the squares of a
 * range of numbers and the square of the sum
 */
public class Problem6
{
    /**
     * Sums consecutive numbers in a range
     * @param min Minimum number in the range
     * @param max Maximum number in the range
     * @return The sum
     */
    public static int sumConsec( int min, int max )
    {
        int count = max - min + 1;
        return ((min + max) * count)/2;
    }

    /**
     * Sums consecutive numbers squares in a range
     * @param min Minimum number in the range
     * @param max Maximum number in the range
     * @return The sum of squares
     */
    public static int sumConsecSquares( int min, int max )
    {
        int res = 0;
        for( int i = min; i <= max; i++ )
        {
            res += i * i;
        }
        return res;
    }

    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        boolean valid;
        int min;
        int max;
        int sum;
        int squareOfSum;
        int sumOfSquares;
        int result;

        do
        {
            valid = true;
            System.out.println("Input the minimum of the range");
            min = input.nextInt();
            System.out.println("Input the maximum of the range");
            max = input.nextInt();

            if (min > max)
            {
                System.out.println("Invalid Range! Try again");
                valid = false;
            }
        } while( !valid );

        sum = sumConsec( min, max );

        squareOfSum = sum * sum;
        sumOfSquares = sumConsecSquares( min, max );

        result = squareOfSum - sumOfSquares;

        System.out.print( "The difference between the square of sums and the sum of squares" );
        System.out.println( " between the numbers " + min + ", " + max + " is " + result );

    }
}
