public class Extras {

    public static boolean validCreditCard(String l) {
        return isValid(Long.parseLong(l));
    }

    private static boolean isValid(long number) {

        // Checking prefix of number to be 4,5,37 or 6 and number of digits are between
        // 13 and 16
        if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37)
                || prefixMatched(number, 6) && getSize(number) >= 13 && getSize(number) <= 16) {
            // Taking sum of double even and odd number places
            int sumOfEvenAndOdd = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);

            // If sum is divisible by 10, the number is valid else not valid
            if (sumOfEvenAndOdd % 10 == 0)
                return true;

            else
                return false;

        }

        else
            return false;

    }

    /** Get the result from Step 2 */
    private static int sumOfDoubleEvenPlace(long number) {
        // Declaring & Initializing Variables
        int mod, double_mod, digit;
        int count = 1;
        int sum = 0;

        // Getting sum
        do {
            // Taking numbers from right to left
            mod = (int) (number % 10);
            number /= 10;

            if (count % 2 == 0) {
                // Getting double of number at even places
                double_mod = mod * 2;
                // Getting sum of each digit in double
                digit = getDigit(double_mod);
                // Adding the value of digit in sum
                sum = sum + digit;

            }
            // incrementing place after every iteration
            count++;

        } while (number != 0); // Repeating till the most left digit of the number

        // Return sum to function
        return sum;

    }

    // Return number for doubling of the numbers at even places
    private static int getDigit(int number) {
        // If number has single digit then return number as it is
        if (number >= 0 && number <= 9)
            return number;
        // If number has 2 digits add both digits
        else {
            // getting last digit
            int mod = number % 10;
            // Getting first digit
            int remaining = number / 10;
            // Get the number
            int digit = remaining + mod;
            // Return number
            return digit;
        }

    }

    // Return sum of odd-place digits in number
    private static int sumOfOddPlace(long number) {
        // Initialzing and declaring variables
        int mod;
        int sum = 0;
        int count = 1;

        // Starting do while to calculate sum of numbers at odd places
        do {
            // getting digits fro right to left
            mod = (int) (number % 10);
            number /= 10;

            // Checkind odd places and adding the number to the sum
            if (count % 2 != 0) {

                sum = sum + mod;
            }
            // Incrementing place number for loop
            count++;

        } while (number != 0);// Repeating until the left most digit of number
        // Returning sum value to function
        return sum;

    }

    // Return true if the digit d is a prefix for number
    // Checking prefix of the number

    private static boolean prefixMatched(long number, int d) {
        // Checking if the prefix matches the number d
        if (getPrefix(number, getSize(d)) == d) {
            return true;
        } else
            return false;

    }

    // Return the number of digits in entered number
    private static int getSize(long d) {
        // Convert number to string
        String string_num = Long.toString(d);
        // return string length to get number of digits in entered number
        return string_num.length();

    }

    /**
     * Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number.
     */

    private static long getPrefix(long number, int k) {

        if (getSize(number) > k) {
            // changing number to string
            String card_Num = Long.toString(number);
            String sub_card = card_Num.substring(0, k);

            Long num = Long.parseLong(sub_card);

            // Returning num
            return num;
        }

        return number;

    }

}
