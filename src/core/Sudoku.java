
package core;

import interfaces.core.GridElement;
import interfaces.core.SudokuGrid;

/**
 * Represents a real sudoku. Sudoku elements are stored in one dimensional array.
 * 
 * @author Alexandar Atanasov
 */
public class Sudoku implements SudokuGrid{
    private GridElement[] elements;
    
    /**
     * Default constructor. Creates new sudoku with all elements set to "UNKNOWN" value.
     */
    public Sudoku(){
        initializeElements();
    }
    
    @Override
    public int getSize(){
        return elements.length;
    }
    
    @Override
    public GridElement getElement(int elementIndex){
        if(elementIndex >= SudokuConstants.SUDOKU_GRID_SIZE || elementIndex < 0){
            // error
            throw new IllegalArgumentException("elementIndex out of bounds - " + elementIndex);
        }
        
        return elements[elementIndex];
    }
    
    @Override
    public String toString(){
        String result = "";
        int counter = 1;
        
        for(GridElement element : this.elements) {
            result+= element.toString();
            
            if(counter % 9 == 0){
                // next row
                result+="\n";
            }
            
            counter++;
        }
        
        return result;
    }
    
    @Override
    public void clear(){
        for(int c =0; c<this.elements.length;c++){
            this.elements[c].setSudokuValue(SudokuConstants.SudokuValues.UNKNOWN);
        }
    }
    
    private void initializeElements(){
        this.elements = new SudokuElement[SudokuConstants.SUDOKU_GRID_SIZE];
        
        for(int c=0; c < this.elements.length; c++){
            this.elements[c] = new SudokuElement();
        }
    }
          
}
