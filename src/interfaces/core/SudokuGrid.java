
package interfaces.core;

/**
 * 
 * Classes which implement this interface should be in one form or another collections of 
 * GridElement objects representing a real Sudoku.
 * 
 * @author Alexandar Atanasov
 */
public interface SudokuGrid {
    /**
     * Returns reference to a single GridElement object specified by the elementIndex parameter.
     * 
     * @param elementIndex should be in the interval [0, SUDOKU_GRID_SIZE - 1] inclusive on both ends.
     * @return Reference to the element designated by the elementIndex parameter.
     */
    public GridElement getElement(int elementIndex);
    
    /**
     * 
     * @return The number of elements in the current sudoku.
     */
    public int getSize();
    
    /**
     * Sets all elements to the "UNKNOWN" value
     */
    public void clear();
}
    
