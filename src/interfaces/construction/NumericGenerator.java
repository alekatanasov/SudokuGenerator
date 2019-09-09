

package interfaces.construction;

/**
 *
 * @author Alexandar Atanasov
 */
public interface NumericGenerator {
    /**
     * Generates a number in the interval [1, upperBound] inclusive on both ends.
     * 
     * @param upperBound cannot be less than 1
     * @return Randomly generated number in the specified interval. If the forbiddenValues
     *         parameter is not null the number returned will not match the values found in it.
     */
    public int generateRandomInt(int upperBound, int[] forbiddenValues);
}
