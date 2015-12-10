package dido.code.hashing;

public interface BytesConverter<T> {

	/**
	 * Converts the given data into bytes.
	 *
	 * @param <T>
	 */
	public byte[] convert(T data);
}
