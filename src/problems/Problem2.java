package problems;

/**
 * Created by george on 5/22/15.
 *
 * Finds the sum of all even Fibonacci numbers where the last term does not exceed 4 million
 */
public class Problem2
{
    public static void main( String [] args )
    {
        int sum = 0;

        int first = 0;
        int second = 1;

        while( first <= 4000000 )
        {
            if( (first & 1) == 0 )
            {
                sum += first;
            }

            int temp = first + second;
            first = second;
            second = temp;
        }

        System.out.println( sum );
    }
}
