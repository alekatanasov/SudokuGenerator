
package interfaces.construction;

import interfaces.construction.GridObfuscator.ObfuscationLevel;

/**
 *
 * @author Alexandar Atanasov
 */
public interface SudokuGenerator {
    public String generateSudoku(ObfuscationLevel difficulty);
}
