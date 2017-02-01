package puzzles.p12;

/**
 * Created by tomi on 1/25/17.
 */
public class ABC {

    public static void main(final String[] args) {
        final String letters = "ABC";
        final char[] ints = {'1', '2', '3'};
        final int[] nums = {1, 2, 3};
        final Integer[] wInts = {1, 2, 3};

        //String concatenation operator is not defined in terms of these methods.
        //It's defined to perform String conversion on both of its operands
        //and then concatenate the results.
        //String conversion including arrays are defined in JLS 15.18.1.1
        System.out.println(letters + " easy as " + ints + " also ugly: " + nums);


        System.out.println(letters + " easy as " + String.valueOf(ints) + " also ugly: " + nums);

        System.out.println(ints);
        System.out.println(nums);
        System.out.println(wInts);
    }
}
