package problems;

import java.util.Scanner;

/**
 * Created by george on 5/23/15.
 *
 * Determines the smallest positive number that is evenly divisible by all numbers between a range of number
 * specified by the client.
 */
public class Problem5
{

    public static void main( String [] args )
    {
        Scanner input = new Scanner(System.in);
        boolean incorrect;
        boolean notfound;
        int min;
        int max;
        int num = 0;


        do
        {
            incorrect = false;
            System.out.println("Enter the min of the range");
            min = input.nextInt();
            System.out.println("Enter the max of the range");
            max = input.nextInt();

            if( min > max )
            {
                System.out.println( "Range Error! Format of range must be min, max" );
                incorrect = true;
            }
        } while( incorrect );

        do
        {
            num += max;
            notfound = false;
            for(int i = min; i <= max; i++ )
            {
                if( num % i != 0 )
                    notfound = true;
            }
        } while( notfound );

        System.out.println( num );
    }
}
