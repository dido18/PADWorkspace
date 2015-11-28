package dido.code;

import java.util.*;
import dido.code.hashing.*;

public class RunnerConsistentHashing{


public static void main(String[] args){

  ArrayList <String> nodes  = new ArrayList<String>();
  nodes.add("a");
  nodes.add("b");
  nodes.add("c");
  nodes.add("g");

  ConsistentHash<String> cs1 = new ConsistentHash<String>( 1, new HashSha(), nodes);

  System.out.println("a maps to node: "+cs1.mapValueToNode("a").toString()); // must be 1
  System.out.println("c maps to node: "+ cs1.mapValueToNode("c").toString()); //must be 4
  System.out.println("b maps to node: "+ cs1.mapValueToNode("b").toString()); //must be 1
  System.out.println("d maps to node: "+ cs1.mapValueToNode("d").toString()); //must be 4
  System.out.println("e maps to node: "+ cs1.mapValueToNode("e").toString()); //must be 1
  System.out.println("f maps to node: "+ cs1.mapValueToNode("f").toString()); //must be NULL
  System.out.println("mamma maps to node: "+ cs1.mapValueToNode("mamma").toString()); //must be NULL
  System.out.println("babbo maps to node: "+ cs1.mapValueToNode("babbo").toString()); //must be NULL

  System.out.print(cs1);

}

}
