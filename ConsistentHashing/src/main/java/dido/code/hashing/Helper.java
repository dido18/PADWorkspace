package dido.code.hashing;

import java.nio.ByteBuffer;
import java.security.*;

public class Helper {
	// Helper implementations

	public static final HashFunction SHA1 = new SHA1HashFunction();

	public static HashFunction getSHA1HashFunction() {
		return SHA1;
	}

	/**
	 * Returned object is thread safe.
	 *  
	 * @return BytesConverter<String>  
	 */
	public static BytesConverter<String> getStringToBytesConverter() {
		return new BytesConverter<String>() {

			@Override
			public byte[] convert(String data) {
				return data.getBytes();
			}
		};
	}

	public static class SHA1HashFunction implements HashFunction {

		@Override
		public byte[] hash(byte[] input) {
			byte[] output = null ;
			try{
			      MessageDigest md = MessageDigest.getInstance("SHA1");
			      md.update(input);
			      output = md.digest();			
			      return output;
			     }catch(Exception e) {
			        System.out.println("Exception: "+e);
			     }
			return output;
			//return Hashing.sha1().hashBytes(input).asBytes();
		}
	}

	/**
	 * Returned object is thread safe.
	 * 
	 * @return
	 */
	public static BytesConverter<Integer> getIntegerToBytesConverter() {
		return new BytesConverter<Integer>() {
			@Override
			public byte[] convert(Integer input) {
				byte[] inputBytes = new byte[Integer.BYTES / Byte.BYTES];
				ByteBuffer bb = ByteBuffer.wrap(inputBytes);
				bb.putInt(input);
				return inputBytes;
			}
		};
	}


}
