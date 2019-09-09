
package core;

import interfaces.core.SudokuGrid;

/**
 * Represents row subset in a sudoku.
 * 
 * @author Alexandar Atanasov
 */
public class SudokuRow extends SudokuSubset{
    public SudokuRow(int index, SudokuGrid parentGrid){
        super(index);
        linkToGrid(parentGrid);
    }
    
    @Override
    public void linkToGrid(SudokuGrid targetGrid){
        int elementIndex;
        
        // perform linking with member elements
        for(int c = 0; c < SudokuSubset.SUBSET_SIZE; c++){
            // calculate proper element index
            elementIndex = c + SudokuSubset.SUBSET_SIZE * (getGridIndex()-1);
            
            // store reference to the current row in the element
            targetGrid.getElement(elementIndex).linkToGridSubset(this);
            
            // store reference to the element
            addMemberElement(targetGrid.getElement(elementIndex));
        }
    }
}
