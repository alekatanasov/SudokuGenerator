
package interfaces.core;

/**
 * 
 * Classes which implement this interface can have their instance reference loaded to elements 
 * of a SudokuGrid and can also store references to the linked elements.
 * Selection of which elements to link with depends on the implementing classes role in the grid and
 * their index.
 * 
 * @author Alexandar Atanasov
 */
public interface GridLoadable {
    public void linkToGrid(SudokuGrid targetGrid);
}
