package problems;

/**
 * Created by george on 5/22/15.
 *
 * Finds the sum of the numbers divisible by 3 and 5 less than 1000
 */
public class Problem1
{

    public static void main( String [] args )
    {
        int n = 0;
        int sum = 0;

        while( n < 1000 )
        {
            if (n % 3 == 0 || n % 5 == 0)
            {
                sum += n;
            }
            n++;
        }
        System.out.println( sum );
    }
}
