package dido.net;

import java.io.*;
import java.net.*;
import java.util.*;


public class NameServer {
	
	
	private HashMap<String, InetAddress> nameToIp ;
	private int seedPort;
	private ServerSocket ss = null;
	
	public NameServer(int sPort){
		seedPort = sPort;
		
	}
	
	public void putOnline(){
		 try {
			ss = new ServerSocket(seedPort);
			while(true){
				Socket connection = null;
				try{
					System.out.println("server is listening on port "+ seedPort);
					connection = ss.accept();
					// logic code of the server accepted connection from a client
					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					out.write(now.toString() +"\r\n");
					out.flush();
					connection.close();
				}catch (IOException ex) {
					// this request only; ignore
				}finally{
					try{
						if(connection != null)
							connection.close();
					}catch (IOException ex) {}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
		  try {
				if (ss != null) ss.close(); // alwayes close a socket whe finish
				} catch (IOException ex) {}
		}
		
	}
	
	public void addName(String nameHost, InetAddress ip){
		nameToIp.put(nameHost, ip);
		
	}
	
	public InetAddress lookup(String nameHost){
		InetAddress iphost = null;
		if(nameToIp.containsKey(nameHost))
			iphost =nameToIp.get(nameHost);
		return iphost;
		
	}
	
	
	public static void main(String args[]){
		NameServer nm = new NameServer(12345);
		nm.putOnline();
		
	}


}
