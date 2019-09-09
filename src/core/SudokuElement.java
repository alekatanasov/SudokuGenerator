
package core;

import interfaces.core.GridElement;
import interfaces.core.GridLoadable;
import interfaces.core.GridSubset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Represents single number box in a sudoku and can hold one SudokuValue. 
 * Can hold references to class instances with additional analyzing and processing 
 * capabilities( inheritors of SudokuSubset class ).
 * 
 * @author Alexandar Atanasov
 */

public class SudokuElement implements GridElement {
    private SudokuConstants.SudokuValues sudokuValue;
    private List<GridSubset> loadedSudokuSubSets;
    
    /**
     * Standard constructor
     * Constructs a blank element (with sudoku value "UNKNOWN").
     */
    public SudokuElement(){
        this.loadedSudokuSubSets = new ArrayList<>();
        this.setSudokuValue(SudokuConstants.SudokuValues.UNKNOWN);
    }
    
    @Override
    public final void setSudokuValue(SudokuConstants.SudokuValues newValue){
        this.sudokuValue = newValue;
    }
    
    @Override
    public final SudokuConstants.SudokuValues getSudokuValue(){
        return this.sudokuValue;
    }
    
    @Override
    public List<GridSubset> getLinkdedGridSubsets(){
        return this.loadedSudokuSubSets;
    }
    
    @Override
    public void linkToGridSubset(GridSubset subset){
        this.loadedSudokuSubSets.add(subset);
    }
    
    @Override
    public String toString(){
        if(getSudokuValue() == SudokuConstants.SudokuValues.UNKNOWN){
            return " ";
        }
        
        return Integer.toString(getSudokuValue().getValue());
    }
        
}
