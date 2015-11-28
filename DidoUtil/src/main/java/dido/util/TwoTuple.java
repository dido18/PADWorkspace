package dido.util;

//import dido.util.*;

public class TwoTuple<A,B> {
  public final A a;  //final : forma più concisa e semplice di private con getters() e setters()
  public final B b;  // clients possono leggere gli oggetti ma non possono assegnarli altri oggetti.

  public TwoTuple( A a, B b){
    this.a = a;
    this.b = b;
  }

  public String ToString(){
    return "("+a+","+b+ ")";
  }


}
