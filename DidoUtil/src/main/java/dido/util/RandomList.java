package dido.util;
/* java.dido.util.RandomList.java
*  Implement list with generics type, with a random selection
*  of an item contained.
*/
import java.util.ArrayList;
import java.util.Random;

public class RandomList <T> {

  private ArrayList<T> storage;
  private Random randomGenerator = new Random();

  public RandomList(int size){
      storage= new ArrayList<T>(size);
      randomGenerator = new Random();
  }

  public void add(T item){
     this.storage.add(item);
  }

  public T select(){
    int randomInt = randomGenerator.nextInt(this.storage.size());
    return storage.get(randomInt);
  }
/*
 public static void main(String[] argc){
   RandomList<Point> rlp = new RandomList<>(4);
   for(int i=0; i<4;i++)
    rlp.add( new Point(i,i));

   System.out.println(rlp.select());
   System.out.println(rlp.select());
 }
 */
}
