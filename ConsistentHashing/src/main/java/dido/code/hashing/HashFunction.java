package dido.code.hashing;


public interface HashFunction {
	/**
	 * Converts the given data into bytes.
	 *
	 */
	
  public byte[] hash(byte [] input) ;

}
