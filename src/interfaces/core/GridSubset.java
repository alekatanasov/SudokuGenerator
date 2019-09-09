
package interfaces.core;

import core.SudokuConstants;
import java.util.Set;

/**
 *
 * Represents a subset of a Sudoku Grid with the special property that no repeating 
 * Sudoku Values are allowed with the exception of the 'UNKNOWN' value.
 * 
 * @author Alexandar Atanasov
 */
public interface GridSubset extends GridLoadable {
    /**
     * 
     * @return set containing the already present Sudoku values (different than 'UNKNOWN')
     *         in the current subset. The returned result will not contain the "UNKNOWN" value 
     *         even if it is present in one or more places in the current subset.
     */
    public Set<SudokuConstants.SudokuValues> checkOccupiedValues();
}
