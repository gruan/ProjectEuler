package problems;

/**
 * Created by george on 5/24/15.
 *
 * Finds the product abc to a Pythagorean triplet for which a + b + c = 1000.
 */
public class Problem9
{
    /**
     * Default constructor for Problem 9
     */
    public Problem9()
    {}

    // 2*an + 2*bn - 2*ab = n^2
    public int[] PythagTriplet( int n )
    {
        int [] result = new int[3];
        for( int a = 1; a <= n/3; a++ )
        {
            for( int b = (a+1); (a + 2*b + 1) <= n; b++ )
            {
                int c = n - a - b;
                if( c > b)
                {
                    int temp = 2 * a * n + 2 * b * n - 2 * a * b;
                    if( temp == (n*n) )
                    {
                        result[0] = a;
                        result[1] = b;
                        result[2] = c;
                        return result;
                    }
                }
            }
        }
        return new int[3];
    }

    public static void main( String [] args )
    {
        int [] resultArr;
        Problem9 p9 = new Problem9();

        int n = 1000;
        resultArr = p9.PythagTriplet( n );

        int result = 1;
        for( int entry : resultArr )
        {
            result *= entry;
        }

        System.out.format( "The unique product abc to a Pythagorean triplet for which a + b + c = %d is %d\n", n, result );

    }
}
