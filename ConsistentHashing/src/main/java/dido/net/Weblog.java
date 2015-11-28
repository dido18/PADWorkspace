package dido.net;

import java.io.*;
import java.net.*;

public class Weblog {

	public static void main(String[] args) {
		/**
		 * Take  in input a log file of a webserver. 
		 * Process it and retrieve more information about the host that has been request something
		 */
		
		String filelog = "/home/dido-ubuntu/PADworkspace/ConsistentHashing/src/main/java/dido/net/weblog.log";
		try (FileInputStream fin = new FileInputStream(filelog);//args[0] 
			Reader in = new InputStreamReader(fin);
			BufferedReader bin = new BufferedReader(in);) 
			{
			
				for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
					//separate out the IP address
					int index = entry.indexOf(' ');
					String ip = entry.substring(0, index);
					String theRest = entry.substring(index);
					
					// Ask DNS for the hostname and print it out
					try {
						InetAddress address = InetAddress.getByName(ip);
						System.out.println(address.getHostName() + theRest);
					} catch (UnknownHostException ex) {
						System.err.println(entry);
					}
					}
				} catch (IOException ex) {
				System.out.println("Exception: " + ex);
				}
		}

}
