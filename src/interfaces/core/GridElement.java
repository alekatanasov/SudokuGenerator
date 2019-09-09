
package interfaces.core;

import core.SudokuConstants;
import java.util.List;

/**
 * 
 * Implementing classes can store references to GridLoadable objects.
 * Implementing classes should store single SudokuValue.
 * 
 * @author Alexandar Atanasov
 */
public interface GridElement {
    public void linkToGridSubset(GridSubset gridSubset);
    
    public SudokuConstants.SudokuValues getSudokuValue();
    
    public void setSudokuValue(SudokuConstants.SudokuValues newValue);
    
    /**
     * 
     * @return null if the current GridElement is not linked to any GridSubsets. Otherwise the method
     *         will return non empty list containing the GridSubsets linked to the current GridElement.
     */
    public List<GridSubset> getLinkdedGridSubsets();
}
