
package core;

import interfaces.core.GridElement;
import interfaces.core.GridSubset;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents functionality common to lines, columns and squares.
 * 
 * @author Alexandar Atanasov
 */
public abstract class SudokuSubset implements GridSubset {
    public static final int SUBSET_SIZE = 9; // default number of linked GridElements belonging to the subset
    private int gridIndex; // used to calculate which members of a Grid should belong to the current subset
    private List<GridElement> memberElements; // stores references to GridElements belonging to this subset
    
    /**
     * Standard constructor.
     * 
     * @param index The index of the current subset in the grid.
     *              Used to calculate which members of a Grid should be linked to the current subset.
     */
    public SudokuSubset(int index){
        setGridIndex(index); 
        initialyzeMemberElements();
    }

    /**
     * 
     * @return the current subset's index in the sudoku grid
     */
    public final int getGridIndex(){
        return this.gridIndex;
    }
            
    @Override
    public Set<SudokuConstants.SudokuValues> checkOccupiedValues(){
        Set<SudokuConstants.SudokuValues> result = EnumSet.noneOf(SudokuConstants.SudokuValues.class);
        
        for(GridElement element : this.memberElements ) {
            // exlude "Unknown" value
            if(!element.getSudokuValue().equals(SudokuConstants.SudokuValues.UNKNOWN)){
                // add non trivial value to the set
                result.add(element.getSudokuValue());
            }
        }
        
        return result;
    }
    
    private void initialyzeMemberElements(){
        this.memberElements = new ArrayList<>();
    }
    
    private void setGridIndex(int index){
        if(index < 1) {
            throw new IllegalArgumentException("index cannot be less than 1");
        }
        
        this.gridIndex = index;
    }
    
    /**
     * Adds the provided GridElement instance to the memberElements field.
     * 
     * @param element non null GridElement instance
     */
    protected final void addMemberElement(GridElement element){
        // error check
        if(element == null){
            throw new IllegalArgumentException("element cannot be null");
        }
        
        this.memberElements.add(element);
    }
}
