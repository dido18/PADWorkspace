package coffe;

import java.util.*;
import dido.util.Generator;

/**
 *  Example of Generator of different Coffe.
 *  See Generator.java in java.dido.util.Generator
 */
public class GeneratorCoffe implements Generator<Coffe>, Iterable<Coffe>{

  private Class[] types ={ Latte.class, Cappuccino.class, Americano.class};
  private Random rand = new Random(47);
  private int size;

  public GeneratorCoffe(int s){
    this.size = s;
  }

  public Coffe next(){
        try{
            return (Coffe)types[rand.nextInt(types.length)].newInstance(); // = new Latte();
        }catch(Exception e){
          throw new RuntimeException(e);
        }
  }



  class CoffeIterator implements Iterator<Coffe>{
    int  count = size;

    public boolean hasNext(){
      return count > 0;
    }

    public Coffe next(){
      count--;
      return GeneratorCoffe.this.next();
    }
  };

  public Iterator<Coffe> iterator(){
     return new CoffeIterator();
  }


  public static void main(String[] args){
    GeneratorCoffe gen = new GeneratorCoffe(5);
    for(int i=0; i< 5; i++)
      System.out.println(gen.next());
  }
}
