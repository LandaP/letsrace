package za.co.directaxis.assessment.game.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

/**
* Static convenience methods for common tasks, which eliminate code duplication.
*/
public final class Util {

    /**
     * Return ordinal, that is a word representing the rank of a number with respect
     * to  some order, in particular order or position.
     * To evaluate this:
     * - take the modulus of the specified number by dividing it with 10 and 100.
     * - evaluate the ordinal representation based on the modulus.
     *
     * @param input
     * @return
     */
    public static String ordinal(int input) {
        if(input<=0) {
            throw new IllegalArgumentException("Number must be > 0");
        }
        int mod100 = input % 100;
        int mod10 = input % 10;
        if(mod10 == 1 && mod100 != 11) {
            return input + "st";
        } else if(mod10 == 2 && mod100 != 12) {
            return input + "nd";
        } else if(mod10 == 3 && mod100 != 13) {
            return input + "rd";
        } else {
            return input + "th";
        }
    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

   /**
   * Return <tt>true</tt> only if <tt>aText</tt> is not null,
   * and is not empty after trimming. (Trimming removes both
   * leading/trailing whitespace and ASCII control characters.)
   *
   * <P> For checking argument validity, {@link Args#checkForContent} should 
   * be used instead of this method.
   *
   * @param aText possibly-null.
   */
   public static boolean textHasContent(String aText) {
     return (aText != null) && (aText.trim().length() > 0);
   }

  
  /**
  * Return a {@link Logger} whose name follows a specific naming convention.
  *
  * <P>The conventional logger names are taken as   
  * <tt>aClass.getPackage().getName()</tt>.
  * 
  * <P>Logger names appearing in the <tt>logging.properties</tt> config file
  * must match the names returned by this method.
  */
  public static Logger getLogger(Class<?> aClass){
     return Logger.getLogger(aClass.getPackage().getName());  
   }
}