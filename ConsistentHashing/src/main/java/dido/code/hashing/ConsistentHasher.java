package dido.code.hashing;

import java.nio.ByteBuffer;
import java.util.List;

import java.util.SortedMap;
import java.util.TreeMap;



public class ConsistentHasher<N> implements IConsistentHasher<N>{

  private final HashFunction hashFunction;
  private final int numberOfReplicas;
  private final SortedMap<ByteBuffer,N> circle = new TreeMap<ByteBuffer,N>();
  private final dido.code.hashing.BytesConverter<String> nodeToByteConverter;
  private final dido.code.hashing.BytesConverter<String> valueToByteConverter;
  
  public ConsistentHasher(
		  HashFunction f,
		  int numberOfReplicas,
		  dido.code.hashing.BytesConverter<String> bytesConverter,
		  dido.code.hashing.BytesConverter<String> bytesConverter2,
		  List<N> nodes){
	  
	  this.numberOfReplicas = numberOfReplicas;
	  this.nodeToByteConverter =  bytesConverter;
	  this.valueToByteConverter = bytesConverter2;
	  this.hashFunction = f;
	  for(N n: nodes){
		  this.putNode(n);
	  }
	  
  }
@Override
public void putNode(N node) {
	for( int i=0; i<this.numberOfReplicas; i++){
		byte[] byteNode = nodeToByteConverter.convert(node.toString()+i);
		byte[] hashTobyteNode = hashFunction.hash(byteNode);
		ByteBuffer bufferByteNode =  ByteBuffer.wrap(hashTobyteNode);
		circle.put(bufferByteNode,node);
	}	
}

@Override
public void removeNode(N node) {
	for( int i=0; i<this.numberOfReplicas; i++){
		byte[] byteNode = nodeToByteConverter.convert(node.toString()+i);
		byte[] hashByteNode = hashFunction.hash(byteNode);
		ByteBuffer byteBufferHas = ByteBuffer.wrap(hashByteNode);
		circle.remove(byteBufferHas);
	}
	
}
@Override
public N getNodeFromValue(Object o) {
	byte[] byteKey = valueToByteConverter.convert(o.toString());
	byte[] hashByteKey  = hashFunction.hash(byteKey);
	ByteBuffer bufferByteValue=  ByteBuffer.wrap(hashByteKey);
	//Returns a view of the portion of this map whose keys are greater than or equal to fromKey
	SortedMap<ByteBuffer, N> tailNodes = circle.tailMap(bufferByteValue);
	N node;
	if(tailNodes.isEmpty()){
		node = circle.get(circle.firstKey());
	}
	else{
		node = circle.get(tailNodes.firstKey());
	}
	return node;
	
}




  
}
