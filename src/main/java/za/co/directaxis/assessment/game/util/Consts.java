package za.co.directaxis.assessment.game.util;

import java.math.BigDecimal;

/**
* Collected constants of very general utility.
*
*<P> All constants are immutable.
*/
public final class Consts  { 

  public static final String APP_NAME = "LetsRace";
  public static final String APP_VERSION = "1.0.0";
  
  //Common Strings
  public static final String NEW_LINE = System.getProperty("line.separator");
  public static final String FILE_SEPARATOR = System.getProperty("file.separator");
  public static final String PATH_SEPARATOR = System.getProperty("path.separator");

  public static final String EMPTY_STRING = "";
  public static final String SPACE = " ";
  public static final String PERIOD = ".";
  public static final String TAB = "\t";
  public static final String COMMA = ",";
  public static final String DOUBLE_QUOTE = "\"";
  public static final String ELLIPSIS = "...";

  //numbers and algebraic signs
  public static final int POSITIVE = 1;
  public static final int NEGATIVE = -1;
  public static final String PLUS_SIGN = "+";
  public static final String NEGATIVE_SIGN = "-";

  public static final char ZERO = '0';
  public static final char ONE = '1';
  
  // PRIVATE 
  
  /** Prevent object construction.  */
  private Consts(){
    throw new AssertionError();
  }
}