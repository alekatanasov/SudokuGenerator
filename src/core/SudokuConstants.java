

package core;

/**
 *
 * @author Alexandar Atanasov
 */
public final class SudokuConstants {
    public static final int SUDOKU_GRID_SIZE = 81;
    
    public static final int MAXIMUM_SUDOKU_ELEMENT_VALUE = 9;
    
    public enum SudokuValues {
        UNKNOWN(0),
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9);
        
        private int value;
        
        private SudokuValues(int value){
            this.value = value;
        }
        
        public int getValue(){
            return this.value;
        }
    }
}
