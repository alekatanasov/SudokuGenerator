
package interfaces.construction;

import interfaces.core.SudokuGrid;

/**
 *
 * @author Alexandar Atanasov
 */
public interface GridObfuscator {
    /**
     * This enum is used to control the level of obfuscation (and therefore the difficulty) of
     * a sudoku.
     */
    public enum ObfuscationLevel{
        LOW,
        MEDIUM,
        HIGH
    }
    
    /**
     * Sets some random elements of a sudoku grid to "UNKNOWN" value.
     * 
     * @param grid The grid to be obfuscated
     */
    public void obfuscateSudokuGrid(SudokuGrid grid, ObfuscationLevel difficulty);
}
