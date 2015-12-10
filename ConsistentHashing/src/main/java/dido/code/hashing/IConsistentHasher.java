package dido.code.hashing;


public interface IConsistentHasher<N> {
	
	public void putNode(N node) ;
	
	public void removeNode(N node);
	
	public N getNodeFromValue(Object o);
	
	public static interface BytesConverter<T> {

		/**
		 * Converts the given data into bytes.
		 *
		 * @param <T>
		 */
		public byte[] convert(T data);
	}

}
