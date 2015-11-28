package dido.util;

import java.util.*;
//import dido.util.*;

public class TupleTest{

  static TwoTuple<String,Integer> f(){
    return new TwoTuple<String,Integer>("hi",4994);
  }

    static ThreeTuple<String,Integer,Integer> g(){
      return new ThreeTuple<String,Integer,Integer>("hi",4994,5994);
    }
}
