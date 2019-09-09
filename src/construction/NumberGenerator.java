
package construction;

import interfaces.construction.NumericGenerator;
import java.util.Random;

/**
 *
 * @author Alexandar Atanasov
 */
public class NumberGenerator implements NumericGenerator {
    /**
     * Default constructor
     */
    public NumberGenerator(){
        //
    }
    
    @Override
    public int generateRandomInt(int upperBound, int[] forbiddenValues){
        Random random = new Random();
        int randomInt;
        
        // error check
        if(upperBound < 1){
            throw new IllegalArgumentException("upperBound parameter must be greater tha 0");
        }
        
        if(forbiddenValues == null) {
            // any value in the specified interval is ok
            randomInt = random.nextInt(upperBound)+ 1;
            return randomInt;
        }
        
        // generate random values in the specified interval until permited value is created.
        while(true){
            randomInt = random.nextInt(upperBound) + 1; 
            
            // check if generated value is not allowed
            if(this.arrayContainsValue(forbiddenValues, randomInt)){
                continue;
            }
            
            return randomInt;
        }
    }
    
    /**
     * Checks if the provided array contains the integer specified by the 'value' parameter.
     * 
     * @param array
     * @param value
     * 
     * @return True if the array contains the specified value. Otherwise the method returns false.
     */
    private boolean arrayContainsValue(int[] array, int value){
        boolean result = false;
        
        // check for matches
        for(int element : array){
            if(element == value){
                result = true;
                break;
            }
        }
        
        return result;
    }
}
