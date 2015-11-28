package dido.util;
/**
 * A Generics Generators that fill a Collection
 *  with a Generato.
 *
 */
import java.util.*;


//import java.dido.util.*;

public class Generators{

 public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
   for( int i=0; i<n; i++)
      coll.add(gen.next());
    return coll;
  }
}
