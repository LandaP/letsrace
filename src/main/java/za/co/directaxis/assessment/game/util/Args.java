package za.co.directaxis.assessment.game.util;

import java.util.Collection;

/**
* Utility methods for common argument validations.
*
*<P> Replace <tt>if</tt> statements at the start of a method with 
* more compact method calls.
*/
public final class Args {
  
  /**
  * If <tt>aObject</tt> is null, throw a <tt>NullPointerException</tt>.
  *
  */
  public static void checkForNull(Object aObject) {
    if (aObject == null) {
      throw new NullPointerException();
    }
  }
  
  /**
  * Throw an <tt>IllegalArgumentException</tt> if <tt>aText</tt> does not 
  * satisfy {@link Util#textHasContent}.
  *
  * <P>Most text used in an application is meaningful only if it has visible content.
  */
  public static void checkForContent(String aText){
    if( ! Util.textHasContent(aText) ){
      throw new IllegalArgumentException("Text has no visible content");
    }
  }

  /**
  * Throw an <tt>IllegalArgumentException</tt> only if <tt>aCollection.isEmpty</tt> 
  * returns <tt>true</tt>.
  */
  public static void checkForEmpty(Collection<Object> aCollection){
    if (aCollection.isEmpty()) {
      throw new IllegalArgumentException("Collection is empty.");
    }
  }
}
