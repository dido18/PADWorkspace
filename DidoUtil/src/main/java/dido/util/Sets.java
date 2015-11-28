package dido.util;

import java.util.*;

/**
 * This class uses generics methods and allow the
 *  operation of two sets: union, intersection, difference, complement:
 */
public class Sets{

  public static <T> Set<T> union(Set<T> a, Set<T> b){
    Set<T> result = new  HashSet<T>(a);
    result.addAll(b);
    return result;
  }

  public static <T> Set<T> intersection(Set<T> a, Set<T> b){
      Set<T> result = new  HashSet<T>(a);
      result.retainAll(b);
      return result;
  }

  //sottrae il sottoinsieme dal sovrainsieme
  public static <T> Set<T> difference(Set<T> superset, Set<T> subset){
      Set<T> result = new  HashSet<T>(superset);
      result.removeAll(subset);
      return result;
  }
  // Riflessivo-tutto ciò che non è incluso nell'intersezione
  public static <T> Set<T> complement(Set<T> a, Set<T> b){
        return difference(union(a,b),intersection(a,b));
    }

}
