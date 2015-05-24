package problems;

/**
 * Created by george on 5/24/15.
 *
 * Finds the n adjacent digits in the given 1000-digit number in Problem 8 of
 * Project Euler that has the greatest product by using a String and not BigInteger
 */
public class Problem8
{
    private String number;                   // String representing positive number
    private int[] numArray;                  // Array representing number

    /**
     * Public Constructor for Problem8
     * @param number The number to find the greatest product of
     */
    public Problem8( String number )
    {
        this.number = number;
        this.numArray = new int[number.length()];

        for( int i = number.length() - 1; i >= 0; i-- )
        {
            int digit = number.charAt( i ) - 48;
            numArray[i] = digit;
        }
    }

    /**
     * Calculates the largest product of n adjacent numbers in a number
     * represented by a string
     * @param n The number of adjacent numbers i.e n = 3 gives 3*4*5 for 12345
     * @return The largest product of n adjacent numbers
     */
    public long adjProduct( int n )
    {
        long max = 0;
        for( int i = 0; i <= numArray.length - n; i++ )
        {
            long acc = 1;
            for( int j = 0; j < n; j++ )
            {
                acc *= numArray[i+j];
            }

            if( acc > max )
                max = acc;
        }

        return max;
    }

    public static void main(String[] args)
    {
        String str  = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        Problem8 p8 = new Problem8( str );

        long result = p8.adjProduct( 13 );

        System.out.println( "The solution to this problem is " + result );
    }
}
