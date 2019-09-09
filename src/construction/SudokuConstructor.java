package construction;

import core.Sudoku;
import core.SudokuColumn;
import core.SudokuConstants;
import core.SudokuRow;
import core.SudokuSquare;
import interfaces.construction.GridObfuscator;
import interfaces.construction.GridObfuscator.ObfuscationLevel;
import interfaces.construction.NumericGenerator;
import interfaces.construction.SudokuGenerator;
import interfaces.core.GridSubset;
import interfaces.core.SudokuGrid;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * Primary sudoku generating class.
 * 
 * @author Alexandar Atanasov
 */
public class SudokuConstructor implements SudokuGenerator{
    private NumericGenerator intGenerator;
    private GridObfuscator sudokuObfuscator;
    private static final int SINGLE_TYPE_SUBSETS_COUNT = 9;
    private static final int SUBSET_TYPES_COUNT = 3;
    private static final int SUDOKU_SUBSETS_COUNT = SINGLE_TYPE_SUBSETS_COUNT * SUBSET_TYPES_COUNT;
    
    /**
     * default constructor
     */
    public SudokuConstructor(){
        this.intGenerator = new NumberGenerator();
        this.sudokuObfuscator = new SudokuObfuscator(this.intGenerator);
    }
    
    @Override
    public String generateSudoku(ObfuscationLevel difficulty){
        SudokuGrid sudoku = new Sudoku();
        GridSubset[] sudokuSubsets = new GridSubset[SUDOKU_SUBSETS_COUNT];
        int[] forbiddenValues;
        SudokuConstants.SudokuValues elementValue;
        int randomInt;
        
        // prepare the sudoku subsets
        for(int c = 0; c < SINGLE_TYPE_SUBSETS_COUNT; c++){
            sudokuSubsets[c*3] = new SudokuRow(c+1,sudoku);
            sudokuSubsets[c*3+1] = new SudokuColumn(c+1,sudoku);
            sudokuSubsets[c*3+2] = new SudokuSquare(c+1,sudoku);
        }
        
        // generate random sudoku values and try to fill the grid according to the sudoku rules.
        for(int c = 0; c <sudoku.getSize(); c++){
            forbiddenValues = getElementForbiddenValues(c, sudoku);
            
            // check if there are too many forbiddenValues (9 means an improper sudoku was generated)
            if(forbiddenValues != null){
                if(forbiddenValues.length > 8){
                    // generation has not been successful. Restart loop and try again.
                    c=-1;
                    sudoku.clear();
                    continue;
                }
            }
            
            // new integer is valid. store it in the sudoku
            randomInt = this.intGenerator.generateRandomInt(SudokuConstants.MAXIMUM_SUDOKU_ELEMENT_VALUE, forbiddenValues);
            elementValue = convertIntToSudokuValue(randomInt);
            sudoku.getElement(c).setSudokuValue(elementValue); 
        }
        
        // hide some values in the grid
        this.sudokuObfuscator.obfuscateSudokuGrid(sudoku, difficulty);
        
        // sudoku is ready
        return sudoku.toString();
    }
    
    /**
     * 
     * @param elementIndex
     * @param sudoku
     * @return Integer array containing forbidden values for the specified element. If there are no 
     *         forbidden values the method returns null.
     */
    private int[] getElementForbiddenValues(int elementIndex, SudokuGrid sudoku){
        int[] result = null;
        List<GridSubset> gridSubsets = sudoku.getElement(elementIndex).getLinkdedGridSubsets();
        Set<SudokuConstants.SudokuValues> forbiddenValues = EnumSet.noneOf(SudokuConstants.SudokuValues.class);
        
        // get forbidden values
        for(GridSubset subset : gridSubsets){
            forbiddenValues.addAll(subset.checkOccupiedValues());
        }
        
        // check if there are no forbidden values
        if(forbiddenValues.isEmpty()){
            return result;
        }
        
        // convert enums to integers
        result = forbiddenValues.stream().mapToInt(Enum::ordinal).toArray();
        
        return result;
    }
    
    private SudokuConstants.SudokuValues convertIntToSudokuValue(int value ){
        switch(value){
            case 1:
                return SudokuConstants.SudokuValues.ONE;
            case 2:
                return SudokuConstants.SudokuValues.TWO;
            case 3:
                return SudokuConstants.SudokuValues.THREE;
            case 4:
                return SudokuConstants.SudokuValues.FOUR;
            case 5:
                return SudokuConstants.SudokuValues.FIVE;
            case 6:
                return SudokuConstants.SudokuValues.SIX;
            case 7:
                return SudokuConstants.SudokuValues.SEVEN;
            case 8:
                return SudokuConstants.SudokuValues.EIGHT;
            case 9:
                return SudokuConstants.SudokuValues.NINE;
            case 0:
                return SudokuConstants.SudokuValues.UNKNOWN;
            default:
                    throw new IllegalArgumentException("value must be between 1 and 9 inclusive- " + value);
                
        }
    }
}
