package dido.util;

import java.security.*;
import java.util.Arrays;

public class SHA{

public static byte[] executeSHA(String input){
    byte[] output = new byte[0];
    try{
      MessageDigest md = MessageDigest.getInstance("SHA1");
      System.out.print("Digest length: "+ md.getDigestLength());
      md.update(input.getBytes());
      output = md.digest(); //calc the SHA1 function
      return output;
     }catch(Exception e) {
        System.out.println("Exception: "+e);
     }

     return output;
}

public static String bytesToHex(byte[] b) {
        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7','8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer buf = new StringBuffer();
        for (int j=0; j<b.length; j++) {
          buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
          buf.append(hexDigit[b[j] & 0x0f]);
      }
    return buf.toString();
}

public static  boolean equalsSHA(byte[] first, byte[] second){
    try{
     MessageDigest md = MessageDigest.getInstance("SHA1");
     return md.isEqual(first, second);
    }catch(NoSuchAlgorithmException e) {
      throw new Error(e);
    }
}
/*
public static void main(String[] a) {

    String input = "";
    byte[] out = SHA.executeSHA(input);
    System.out.println("SHA1(\""+input+"\")="+SHA.bytesToHex(out));

    String i = "a";
    byte[] out2 = SHA.executeSHA(i);

    System.out.println(SHA.equalsSHA(out2,out));

}
*/
}
