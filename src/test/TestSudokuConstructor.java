
package test;

import construction.SudokuConstructor;
import interfaces.construction.GridObfuscator.ObfuscationLevel;

/**
 *
 * @author Alexandar Atanasov
 */
public class TestSudokuConstructor {
    public static void main(String args[]){
        SudokuConstructor constructor = new SudokuConstructor();
        String sudoku = constructor.generateSudoku(ObfuscationLevel.HIGH);
        System.out.print(sudoku);
    }
    
}
