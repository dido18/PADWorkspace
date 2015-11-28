package dido.code.hashing;

import java.security.*;

public class HashSha implements HashFunction{

public  byte[] executeSHA(String input){
    byte[] output = new byte[0];
    try{
      MessageDigest md = MessageDigest.getInstance("SHA1");
      md.update(input.getBytes());
      output = md.digest();			
      return output;
     }catch(Exception e) {
        System.out.println("Exception: "+e);
     }
     return output;
}

public String bytesToHex(byte[] b) {
        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7','8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer buf = new StringBuffer();
        for (int j=0; j<b.length; j++) {
          buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
          buf.append(hexDigit[b[j] & 0x0f]);
      }
    return buf.toString();
}

public int bytesToInt(byte[] b){
	int unsignedByte=0;
	 for (int j=0; j<b.length; j++) {
		 // unsignedByte is not the equivalent int value of 20 bytes, but the some of single byte
		  unsignedByte += b[j] < 0 ? b[j] + 256 : b[j];
	 }
	 return unsignedByte;
}

@Override
public String hash(String s) {
	byte[] hash = executeSHA(s);
	//return  bytesToHex(hash);
	Integer r = bytesToInt(hash);
	return r.toString();
	}

}




