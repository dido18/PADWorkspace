package dido.code.hashing;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;


public class ConsistentHash<T>{

  private final HashFunction hashFunction;
  private final int numberOfReplicas;
  private final SortedMap<String,T> circle = new TreeMap<String,T>();

  public ConsistentHash( int numReplicas, HashFunction f, Collection<T> nodes) {
    this.hashFunction = f;
    this.numberOfReplicas= numReplicas;
    for( T n : nodes)
       add(n); // add the initial nodes with replicas
  }
  
  /**
   * Adds a node into the network with virtual nodes if *numOfReplicas* > 1.
   * @param node Is node to be added in  the network
   */

  private void add(T node){	  
     for(int i = 0; i < this.numberOfReplicas; i++){
    	  String keyNode = this.hashFunction.hash(node.toString()+ i);
    	  System.out.println("hash +" + i +" virtula Node :" +node.toString() + " = "+ keyNode);
          circle.put(keyNode, node);
    }
  }
  
 @SuppressWarnings("unused")
 private void remove( T node){
	  for(int i = 0; i < this.numberOfReplicas; i++){
		  String keyNode = this.hashFunction.hash(node.toString()+ i);
	  		System.out.println("Remove " + i +" virtul Node :" +node.toString() + " = "+ keyNode);
	  		circle.remove(keyNode, node);
	  }
	  
  }

 /**
  * Return the node where the value is stored in a clockwise direction
  * @param  value  value to be searched in the network.
  * @return        T node holding the value.
  */
  public T mapValueToNode( T value){
      if(circle.isEmpty())
        return null;
      String hashValue = this.hashFunction.hash(value.toString());
      if(!circle.containsKey(hashValue)){ // if value is not a node present
	      SortedMap<String,T> greaterMapKeys = circle.tailMap(hashValue); 
	      hashValue=greaterMapKeys.isEmpty()? circle.firstKey():greaterMapKeys.firstKey();
      }
      System.out.println("hash value of :" +value.toString() + " = "+ hashValue);
      return circle.get(hashValue);
  }

  public String toString(){
	  String result = "Circle <key,values>: \n";
	  for (Entry<String, T> entry : circle.entrySet()) {
		  result += entry.getKey()+ ": ";
		  result += entry.getValue().toString() + "\n";
		}
	  return result;
  }
}
