
package core;

import interfaces.core.SudokuGrid;

/**
 * Represents a square subset in a sudoku.
 * 
 * @author Alexandar Atanasov
 */
public class SudokuSquare extends SudokuSubset{
    public SudokuSquare(int index, SudokuGrid parentGrid){
        super(index);
        linkToGrid(parentGrid);
    }
    
    @Override
    public void linkToGrid(SudokuGrid targetGrid){
        int elementIndex = -1;
        
        // perform linking with member elements
        for(int c = 0; c < SudokuSubset.SUBSET_SIZE; c++){
            // element index calculations
            if(this.getGridIndex() <= 3){
                if(c <= 2){
                    elementIndex = c + (this.getGridIndex() - 1) * 3;
                } else if(c > 2 && c < 6) {
                    elementIndex = c + SudokuSubset.SUBSET_SIZE - 3 + (this.getGridIndex() - 1) * 3;
                } else {
                    elementIndex = c + (SudokuSubset.SUBSET_SIZE*2) - 6 + (this.getGridIndex() - 1) * 3;
                }
            } else if (this.getGridIndex() > 3 && this.getGridIndex() < 7) {
                if(c <= 2){
                    elementIndex = c + (SudokuSubset.SUBSET_SIZE*3)+ (this.getGridIndex() - 4) * 3;
                } else if(c > 2 && c < 6) {
                    elementIndex = c + (SudokuSubset.SUBSET_SIZE*4)-3 + (this.getGridIndex() - 4) * 3;
                } else {
                    elementIndex = c + (SudokuSubset.SUBSET_SIZE*5)-6 + (this.getGridIndex() - 4) * 3;
                }     
            } else {
                if(c <= 2){
                    elementIndex = c + (SudokuSubset.SUBSET_SIZE*6)+ (this.getGridIndex() - 7) * 3;
                } else if(c > 2 && c < 6) {
                    elementIndex = c + (SudokuSubset.SUBSET_SIZE*7)-3+ (this.getGridIndex() - 7) * 3;
                } else {
                    elementIndex = c + (SudokuSubset.SUBSET_SIZE*8) -6+ (this.getGridIndex() - 7) * 3;
                }
            }
            
            targetGrid.getElement(elementIndex).linkToGridSubset(this);
            addMemberElement(targetGrid.getElement(elementIndex));
            
        }
    }
}
