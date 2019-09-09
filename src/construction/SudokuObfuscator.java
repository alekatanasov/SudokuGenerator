

package construction;

import core.SudokuConstants;
import static core.SudokuConstants.SUDOKU_GRID_SIZE;
import interfaces.construction.GridObfuscator;
import interfaces.construction.NumericGenerator;
import interfaces.core.SudokuGrid;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to hide( set to value "UNKNOWN") some of the elements of
 * a sudoku grid.
 * 
 * @author Alexandar Atanasov
 */
public class SudokuObfuscator implements GridObfuscator{
    private NumericGenerator integerGenerator;
    
    /**
     * Standard constructor
     * 
     * @param generator reference to an existing NumericGenerator instance. Can not be null.
     */
    public SudokuObfuscator(NumericGenerator generator){
        setIntegerGenerator(generator);
    }
    
    @Override
    public void obfuscateSudokuGrid(SudokuGrid grid, ObfuscationLevel difficulty){
        basicObfuscate(grid, difficulty);
    }
    
    private void setIntegerGenerator(NumericGenerator generator){
        if(generator == null){
            throw new IllegalArgumentException("generator can not be null");
        }
        
        this.integerGenerator = generator;
    }
    
    private NumericGenerator getIntegerGenerator(){
        return this.integerGenerator;
    }
    
    /**
     * Performs crude obfuscation. Several grid elements are chosen at random (number depends on
     * difficulty parameter) and are set to "UNKNOWN" value.
     * 
     * @param grid
     * @param difficulty 
     */
    private void basicObfuscate(SudokuGrid grid, ObfuscationLevel difficulty){
        int obfuscationCount;
        int gridElementPosition;
        List <Integer>obfuscatedElements = new ArrayList<>();
        
        switch(difficulty){
            case LOW:
                obfuscationCount = 9;
                break;
            case MEDIUM:
                obfuscationCount = 18;
                break;
            case HIGH:
                obfuscationCount = 27;
                break;
            default:
                throw new IllegalArgumentException("Unknown onfuscation level");
        }
        
        // perform obfuscation
        for(int c = 1; c <= obfuscationCount; c++){
            gridElementPosition = getIntegerGenerator().generateRandomInt(SUDOKU_GRID_SIZE - 1, null);
            grid.getElement(gridElementPosition).setSudokuValue(SudokuConstants.SudokuValues.UNKNOWN);
        }
    }
}
