
package core;

import interfaces.core.SudokuGrid;

/**
 * Represents column subset in a sudoku.
 * 
 * @author Alexandar Atanasov
 */
public class SudokuColumn extends SudokuSubset{
    public SudokuColumn(int index, SudokuGrid parentGrid){
        super(index);
        linkToGrid(parentGrid);
    }
    
    @Override
    public void linkToGrid(SudokuGrid targetGrid){
        int elementIndex;
        
        // perform linking with member elements
        for(int c = 0; c < SudokuSubset.SUBSET_SIZE; c++){
            elementIndex = c * SudokuSubset.SUBSET_SIZE + getGridIndex()-1;
            targetGrid.getElement(elementIndex).linkToGridSubset(this);
            addMemberElement(targetGrid.getElement(elementIndex));
            
        }
    }
}
