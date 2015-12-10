package dido.code;
import java.util.*;
import dido.code.hashing.*;

public class RunnerConsistentHashing{


public static void main(String[] args){

  String A = "nodeA";
  String B =  "nodeB";
  String C = "nodeC";
  
  
  ArrayList <String> nodes  = new ArrayList<String>();
  nodes.add(A);
  nodes.add(B);
  nodes.add(C);

  ConsistentHasher<String> cs1 =new ConsistentHasher<String>(Helper.SHA1, 3, Helper.getStringToBytesConverter(), Helper.getStringToBytesConverter(), nodes);
  ConsistentHasher<String> cs2 =new ConsistentHasher<String>(Helper.SHA1, 3, Helper.getStringToBytesConverter(), Helper.getStringToBytesConverter(), nodes);
  
  		
  

  String  ALE = "Algorithm Engeneering";
  String  PAD =  "Piattaforme abilitanti distibuite";
  String  ISS =  "Ingengeria dei servizi software";
  
  // Prima istanze di consistent hashing
  System.out.println("CS1 node: " +cs1.getNodeFromValue(ALE) +" for "+ALE);
  System.out.println("CS1 node: " +cs1.getNodeFromValue(PAD) +" for "+PAD);
  System.out.println("CS1 node: " +cs1.getNodeFromValue(ISS) +" for "+ISS);
  
  System.out.println("---------------------------------------------------");
  
  // Seconda istanze di consistent hashing
  System.out.println("CS2 node: " +cs2.getNodeFromValue(ALE) +" for "+ALE);
  System.out.println("CS2 node: " +cs2.getNodeFromValue(PAD) +" for "+PAD);
  System.out.println("CS2 c node: " +cs2.getNodeFromValue(ISS) +" for "+ISS);
  
  System.out.println("---------------------------------------------------");
  
  System.out.println("Cancello " + A + " dal CS1");
  cs1.removeNode(A);
  System.out.println("Cancello  " + A + " dal CS2");
  cs2.removeNode(A);
  
  System.out.println("---------------------------------------------------");
  
  System.out.println("CS1 node: " +cs1.getNodeFromValue(PAD) +" for "+PAD);
  System.out.println("CS2 node: " +cs2.getNodeFromValue(PAD) +" for "+PAD);
  
	}
}
